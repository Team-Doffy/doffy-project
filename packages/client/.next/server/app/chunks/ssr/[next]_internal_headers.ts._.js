(self.TURBOPACK = self.TURBOPACK || []).push(["chunks/ssr/[next]_internal_headers.ts._.js", {

"[next]/internal/headers.ts (ecmascript, ssr)": (({ r: __turbopack_require__, x: __turbopack_external_require__, i: __turbopack_import__, s: __turbopack_esm__, v: __turbopack_export_value__, c: __turbopack_cache__, l: __turbopack_load__, k: __turbopack_register_chunk_list__, j: __turbopack_cjs__, p: process, g: global, __dirname }) => (() => {

__turbopack_esm__({
    "headersFromEntries": ()=>headersFromEntries,
    "toPairs": ()=>toPairs
});
function headersFromEntries(entries) {
    const headers = Object.create(null);
    for (const [key, value] of entries){
        if (key in headers) {
            const prevValue = headers[key];
            if (typeof prevValue === "string") {
                headers[key] = [
                    prevValue,
                    value
                ];
            } else {
                prevValue.push(value);
            }
        } else {
            headers[key] = value;
        }
    }
    return headers;
}
function toPairs(arr) {
    if (arr.length % 2 !== 0) {
        throw new Error("toPairs: expected an even number of elements");
    }
    const pairs = [];
    for(let i = 0; i < arr.length; i += 2){
        pairs.push([
            arr[i],
            arr[i + 1]
        ]);
    }
    return pairs;
}

})()),
}]);


//# sourceMappingURL=[next]_internal_headers.ts._.js.map