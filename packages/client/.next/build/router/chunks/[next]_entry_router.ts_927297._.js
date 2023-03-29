(self.TURBOPACK = self.TURBOPACK || []).push(["chunks/[next]_entry_router.ts_927297._.js", {

"[next]/entry/router.ts/(MIDDLEWARE_CHUNK_GROUP)/[project]/middleware.js (ecmascript)/(MIDDLEWARE_CONFIG)/[project]/middleware_config.js (ecmascript) (ecmascript)": (({ r: __turbopack_require__, x: __turbopack_external_require__, i: __turbopack_import__, s: __turbopack_esm__, v: __turbopack_export_value__, c: __turbopack_cache__, l: __turbopack_load__, k: __turbopack_register_chunk_list__, j: __turbopack_cjs__, p: process, g: global, __dirname }) => (() => {

__turbopack_esm__({
    "default": ()=>route
});
var __TURBOPACK__external__node$3a$buffer__ = __turbopack_external_require__("node:buffer", true);
var __TURBOPACK__imported__module__$5b$next$5d2f$ipc$2f$server$2e$ts__$28$ecmascript$29__ = __turbopack_import__("[next]/ipc/server.ts (ecmascript)");
var __TURBOPACK__imported__module__$5b$next$5d2f$internal$2f$headers$2e$ts__$28$ecmascript$29__ = __turbopack_import__("[next]/internal/headers.ts (ecmascript)");
var __TURBOPACK__external__next$2f$dist$2f$server$2f$lib$2f$route$2d$resolver__ = __turbopack_external_require__("next/dist/server/lib/route-resolver", true);
var __TURBOPACK__external__next$2f$dist$2f$server$2f$config__ = __turbopack_external_require__("next/dist/server/config", true);
var __TURBOPACK__external__next$2f$dist$2f$shared$2f$lib$2f$constants__ = __turbopack_external_require__("next/dist/shared/lib/constants", true);
var __TURBOPACK__external__next$2f$dist$2f$server$2f$node$2d$polyfill$2d$fetch$2e$js__ = __turbopack_external_require__("next/dist/server/node-polyfill-fetch.js", true);
var __TURBOPACK__imported__module__$5b$project$5d2f$middleware$2e$js__$28$ecmascript$29__ = __turbopack_import__("[project]/middleware.js (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$middleware_config$2e$js__$28$ecmascript$29__ = __turbopack_import__("[project]/middleware_config.js (ecmascript)");
"__TURBOPACK__ecmascript__hoisting__location__";
;
;
;
;
;
;
;
;
;
let resolveRouteMemo;
async function getResolveRoute(dir) {
    const nextConfig = await __TURBOPACK__external__next$2f$dist$2f$server$2f$config__["default"](__TURBOPACK__external__next$2f$dist$2f$shared$2f$lib$2f$constants__["PHASE_DEVELOPMENT_SERVER"], process.cwd(), undefined, undefined, true);
    return await __TURBOPACK__external__next$2f$dist$2f$server$2f$lib$2f$route$2d$resolver__["makeResolver"](dir, nextConfig, {
        files: __TURBOPACK__imported__module__$5b$project$5d2f$middleware$2e$js__$28$ecmascript$29__["default"].filter((f)=>/\.[mc]?js$/.test(f)),
        matcher: __TURBOPACK__imported__module__$5b$project$5d2f$middleware_config$2e$js__$28$ecmascript$29__["default"].matcher
    });
}
async function route(ipc, routerRequest, dir) {
    const [resolveRoute, server] = await Promise.all([
        resolveRouteMemo ??= getResolveRoute(dir),
        __TURBOPACK__imported__module__$5b$next$5d2f$ipc$2f$server$2e$ts__$28$ecmascript$29__["createServer"]()
    ]);
    try {
        const { clientRequest , clientResponsePromise , serverRequest , serverResponse  } = await __TURBOPACK__imported__module__$5b$next$5d2f$ipc$2f$server$2e$ts__$28$ecmascript$29__["makeRequest"](server, routerRequest.method, routerRequest.pathname, routerRequest.rawQuery, routerRequest.rawHeaders);
        clientRequest.end();
        const routePromise = resolveRoute(serverRequest, serverResponse);
        const responsePromise = clientResponsePromise.then((c)=>handleClientResponse(ipc, c));
        const [response] = await Promise.all([
            responsePromise,
            routePromise
        ]);
        server.close();
        return response;
    } catch (e) {
        ipc.sendError(e);
    }
}
async function handleClientResponse(_ipc, clientResponse) {
    if (clientResponse.headers["x-nextjs-route-result"] === "1") {
        clientResponse.setEncoding("utf8");
        let buffer = "";
        for await (const chunk of clientResponse){
            buffer += chunk;
        }
        const data = JSON.parse(buffer);
        switch(data.type){
            case "none":
                return {
                    type: "none"
                };
            case "rewrite":
            default:
                return {
                    type: "rewrite",
                    data: {
                        url: data.url,
                        headers: Object.entries(data.headers)
                    }
                };
        }
    }
    const responseHeaders = {
        statusCode: clientResponse.statusCode,
        headers: __TURBOPACK__imported__module__$5b$next$5d2f$internal$2f$headers$2e$ts__$28$ecmascript$29__["toPairs"](clientResponse.rawHeaders)
    };
    const buffers = [];
    for await (const chunk of clientResponse){
        buffers.push(chunk);
    }
    return {
        type: "full-middleware",
        data: {
            headers: responseHeaders,
            body: __TURBOPACK__external__node$3a$buffer__["Buffer"].concat(buffers).toJSON().data
        }
    };
}

})()),
}]);


//# sourceMappingURL=[next]_entry_router.ts_927297._.js.map