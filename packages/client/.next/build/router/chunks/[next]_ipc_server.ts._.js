(self.TURBOPACK = self.TURBOPACK || []).push(["chunks/[next]_ipc_server.ts._.js", {

"[next]/ipc/server.ts (ecmascript)": (({ r: __turbopack_require__, x: __turbopack_external_require__, i: __turbopack_import__, s: __turbopack_esm__, v: __turbopack_export_value__, c: __turbopack_cache__, l: __turbopack_load__, k: __turbopack_register_chunk_list__, j: __turbopack_cjs__, p: process, g: global, __dirname }) => (() => {

__turbopack_esm__({
    "createServer": ()=>createServer,
    "makeRequest": ()=>makeRequest
});
var __TURBOPACK__external__node$3a$http__ = __turbopack_external_require__("node:http", true);
var __TURBOPACK__imported__module__$5b$next$5d2f$internal$2f$headers$2e$ts__$28$ecmascript$29__ = __turbopack_import__("[next]/internal/headers.ts (ecmascript)");
"__TURBOPACK__ecmascript__hoisting__location__";
;
;
function createServer() {
    return new Promise((resolve)=>{
        const server = __TURBOPACK__external__node$3a$http__["default"].createServer();
        server.listen(0, ()=>{
            resolve(server);
        });
    });
}
function makeRequest(server, method, path, rawQuery, rawHeaders) {
    return new Promise((resolve, reject)=>{
        let clientRequest = null;
        let clientResponseResolve;
        let clientResponseReject;
        const clientResponsePromise = new Promise((resolve, reject)=>{
            clientResponseResolve = resolve;
            clientResponseReject = reject;
        });
        let serverRequest = null;
        let serverResponse = null;
        const maybeResolve = ()=>{
            if (clientRequest != null && serverRequest != null && serverResponse != null) {
                cleanup();
                resolve({
                    clientRequest,
                    clientResponsePromise,
                    serverRequest,
                    serverResponse
                });
            }
        };
        const cleanup = ()=>{
            server.removeListener("error", errorListener);
            server.removeListener("request", requestListener);
        };
        const errorListener = (err)=>{
            cleanup();
            reject(err);
        };
        const requestListener = (req, res)=>{
            serverRequest = req;
            serverResponse = res;
            maybeResolve();
        };
        const cleanupClientResponse = ()=>{
            if (clientRequest != null) {
                clientRequest.removeListener("response", responseListener);
                clientRequest.removeListener("error", clientResponseErrorListener);
            }
        };
        const clientResponseErrorListener = (err)=>{
            cleanupClientResponse();
            clientResponseReject(err);
        };
        const responseListener = (res)=>{
            cleanupClientResponse();
            clientResponseResolve(res);
        };
        server.once("request", requestListener);
        server.once("error", errorListener);
        const address = server.address();
        clientRequest = __TURBOPACK__external__node$3a$http__["default"].request({
            host: "localhost",
            port: address.port,
            method,
            path: rawQuery != null && rawQuery.length > 0 ? `${path}?${rawQuery}` : path,
            headers: rawHeaders != null ? __TURBOPACK__imported__module__$5b$next$5d2f$internal$2f$headers$2e$ts__$28$ecmascript$29__["headersFromEntries"](rawHeaders) : undefined
        });
        clientRequest.flushHeaders();
        clientRequest.once("response", responseListener);
        clientRequest.once("error", clientResponseErrorListener);
    });
}

})()),
}]);


//# sourceMappingURL=[next]_ipc_server.ts._.js.map