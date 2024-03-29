(function(r) {
    var o = "",
        D = "tx_",
        e = "uninitialized",
        x = "loading",
        A = "complete",
        i = "production",
        w = "development",
        u = 1000,
        k = 5;
    var t = /\/(\d+[a-z.]?\.[a-z0-9\-]+\.[\-\w]+)\//;
    var f = {
        environment: i,
        service: "core",
        version: "",
        host: ""
    };

    function C(E) {
        return E.replace(/[^\/]+\/?$/, "")
    }

    function b(F) {
        var E = r.getElementsByTagName("script");
        for (var G = 0; G < E.length; G++) {
            if (E[G].src.indexOf(F) >= 0) {
                return E[G]
            }
        }
        throw "cannot find '" + F + "' script element"
    }

    function g(F) {
        var E = b(F);
        var G = E.src;
        return G.substring(G.indexOf("?") + 1)
    }

    function z(F) {
        var E = b(F);
        var G = E.src.match(t);
        if (G && G.length == 2) {
            return G[1]
        }
        return ""
    }

    function q(E) {
        return f[E] || o
    }

    function m(E) {
        var F = y.parse(g(j.NAME), "&");
        return F.findByName(E)
    }

    function a(E) {
        var G = y.parse(r.cookie, /;[ ]*/);
        var F = G.findByName(D + E);
        return F ? decodeURIComponent(F) : F
    }
    var y = function() {
        this.data = []
    };
    y.prototype = {
        add: function(E, F) {
            this.data.push({
                name: E,
                value: F
            })
        },
        findByName: function(E) {
            var G;
            for (var F = 0; F < this.data.length; F++) {
                if (this.data[F] && this.data[F].name === E) {
                    G = this.data[F].value;
                    break
                }
            }
            return G
        }
    };
    y.parse = function(G, I) {
        var E = new y();
        var J = G.split(I);
        for (var F = 0; F < J.length; F++) {
            var H = J[F].split("=");
            E.add(H[0], H[1])
        }
        return E
    };

    function p(F) {
        var E = r.createElement("script");
        E.type = "text/javascript";
        E.src = F;
        return E
    }

    function l(G) {
        var E = r.location;
        if (G.match(/^(https?:|file:|)\/\//)) {} else {
            if (G.indexOf("/") === 0) {
                G = "http://" + E.host + G
            } else {
		/* 보안 이슈 처리 by hed 2018-01-12 */
                /* URL을 통해 변조될 수 없도록 제거 by hed
                editor 초기화 시 모듈JS를 호출하는데 이때 상대경로를 사용할 수 없도록 변경
                */
                /*
                var F = E.href;
                var H = F.lastIndexOf("/");
                G = F.substring(0, H + 1) + G
                */
               alert("필수 모듈 호출에 실패했습니다.");
            }
        }
        return G
    }

    function d(G, H) {
        var E = p(G);
        var F = r.getElementsByTagName("head")[0] || r.documentElement;
        h(E, F, H);
        F.insertBefore(E, F.firstChild);
        return E
    }

    function h(E, F, G) {
        if (G) {
            E.onload = E.onreadystatechange = function() {
                if (!this.readyState || this.readyState === "loaded" || this.readyState === "complete") {
                    G();
                    if (/MSIE/i.test(navigator.userAgent)) {
                        E.onload = E.onreadystatechange = null;
                        if (F && E.parentNode) {
                            F.removeChild(E)
                        }
                    }
                }
            }
        }
    }

    function s(E) {
        if (typeof E === "function") {
            E(Editor)
        }
    }
    var n = function(E) {
        this.TIMEOUT = k * u;
        this.readyState = e;
        this.url = E.url;
        this.callback = E.callback || function() {};
        this.id = E.id;
        this.load()
    };
    n.prototype = {
        load: function() {
            var G = this.url;
            var F = this;
            try {
                b(G)
            } catch (H) {
                F.readyState = x;
                var E = d(G, function() {
                    F.callback();
                    F.readyState = A
                });
                if (F.id) {
                    E.id = F.id
                }
            }
            return this
        },
        startErrorTimer: function() {
            var E = this;
            setTimeout(function() {
                if (E.readyState !== A) {
                    E.onTimeout()
                }
            }, E.TIMEOUT)
        },
        onTimeout: function() {},
        onLoadComplete: function() {}
    };
    var v = [],
        B;
    var j = {
        NAME: "editor_loader.js",
        TIMEOUT: k * u,
        readyState: e,
        loadModule: function(F) {
            function G(H) {
                return !H.match(/^((https?:|file:|)\/\/|\.\.\/|\/)/)
            }
            var E = G(F) ? this.getJSBasePath() + F : F;
            if (f.environment === w) {
                E = E + "?dummy=" + new Date().getTime()
            }
            r.write('<script type="text/javascript" src="' + E + '" charset="utf-8"><\/script>')
        },
        asyncLoadModule: function(E) {
            return new n(E)
        },
        ready: function(E) {
            if (this.readyState === A) {
                s(E)
            } else {
                v.push(E)
            }
        },
        finish: function() {
            for (var E = 0; E < v.length; E++) {
                s(v[E])
            }
            v = []
        },
        getBasePath: function(F) {
            var G = a("base_path");
            if (!G) {
                var E = b(F || j.NAME);
                G = C(C(E.src))
            }
            return l(G)
        },
        getJSBasePath: function(E) {
            return this.getBasePath() + "js/"
        },
        getCSSBasePath: function() {
            return this.getBasePath() + "css/"
        },
        getPageBasePath: function() {
            return this.getBasePath() + "pages/"
        },
        getOption: function(E) {
            return a(E) || m(E) || q(E)
        }
    };
    window.EditorJSLoader = j;

    function c() {
        var F = "editor.js";
        f.version = z(j.NAME);
        var E = m("environment");
        if (E) {
            f.environment = E
        }
        j.loadModule(F)
    }
    c()
})(document);