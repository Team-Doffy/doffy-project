(self.TURBOPACK = self.TURBOPACK || []).push(["chunks/ssr/[next]_internal_http.ts._.js", {

"[next]/internal/http.ts (ecmascript, ssr)": (({ r: __turbopack_require__, x: __turbopack_external_require__, i: __turbopack_import__, s: __turbopack_esm__, v: __turbopack_export_value__, c: __turbopack_cache__, l: __turbopack_load__, k: __turbopack_register_chunk_list__, j: __turbopack_cjs__, p: process, g: global, __dirname }) => (() => {

__turbopack_esm__({
    "ServerResponseShim": ()=>ServerResponseShim
});
class ServerResponseShim {
    headersSent = false;
    #headers = new Map();
    #statusCode = 200;
    constructor(req){
        this.req = req;
    }
    setHeader(name, value) {
        this.#headers.set(name.toLowerCase(), value);
        return this;
    }
    getHeader(name) {
        return this.#headers.get(name.toLowerCase());
    }
    getHeaderNames() {
        return Array.from(this.#headers.keys());
    }
    getHeaders() {
        return Object.fromEntries(this.#headers);
    }
    hasHeader(name) {
        return this.#headers.has(name.toLowerCase());
    }
    removeHeader(name) {
        this.#headers.delete(name.toLowerCase());
    }
    get statusCode() {
        return this.#statusCode;
    }
    set statusCode(code) {
        this.#statusCode = code;
    }
    get statusMessage() {
        throw new Error("statusMessage is not implemented");
    }
    set statusMessage(message) {
        throw new Error("set statusMessage is not implemented");
    }
    get socket() {
        throw new Error("socket is not implemented");
    }
    get sendDate() {
        throw new Error("sendDate is not implemented");
    }
    flushHeaders() {
        throw new Error("flushHeaders is not implemented");
    }
    end() {
        throw new Error("end is not implemented");
    }
    cork() {
        throw new Error("cork is not implemented");
    }
    uncork() {
        throw new Error("uncork is not implemented");
    }
    addTrailers() {
        throw new Error("addTrailers is not implemented");
    }
    setTimeout(_msecs, _callback) {
        throw new Error("setTimeout is not implemented");
    }
    get writableEnded() {
        throw new Error("writableEnded is not implemented");
    }
    get writableFinished() {
        throw new Error("writableFinished is not implemented");
    }
    write(_chunk, _encoding, _callback) {
        throw new Error("write is not implemented");
    }
    writeContinue() {
        throw new Error("writeContinue is not implemented");
    }
    writeHead(_statusCode, _statusMessage, _headers) {
        throw new Error("writeHead is not implemented");
    }
    writeProcessing() {
        throw new Error("writeProcessing is not implemented");
    }
}

})()),
}]);


//# sourceMappingURL=[next]_internal_http.ts._.js.map