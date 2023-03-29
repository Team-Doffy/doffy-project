(self.TURBOPACK = self.TURBOPACK || []).push(["chunks/[next]_entry_config_next.js", {

"[next]/entry/config/next.js (ecmascript)": (({ r: __turbopack_require__, x: __turbopack_external_require__, i: __turbopack_import__, s: __turbopack_esm__, v: __turbopack_export_value__, c: __turbopack_cache__, l: __turbopack_load__, k: __turbopack_register_chunk_list__, j: __turbopack_cjs__, p: process, g: global, __dirname }) => (() => {

__turbopack_esm__({
    "default": ()=>loadNextConfig
});
var __TURBOPACK__external__next$2f$dist$2f$server$2f$config__ = __turbopack_external_require__("next/dist/server/config", true);
var __TURBOPACK__external__next$2f$dist$2f$lib$2f$load$2d$custom$2d$routes__ = __turbopack_external_require__("next/dist/lib/load-custom-routes", true);
var __TURBOPACK__external__next$2f$dist$2f$shared$2f$lib$2f$constants__ = __turbopack_external_require__("next/dist/shared/lib/constants", true);
var __TURBOPACK__external__node$3a$assert__ = __turbopack_external_require__("node:assert", true);
"__TURBOPACK__ecmascript__hoisting__location__";
;
;
;
;
const loadNextConfig = async (silent)=>{
    const nextConfig = await __TURBOPACK__external__next$2f$dist$2f$server$2f$config__["default"](__TURBOPACK__external__next$2f$dist$2f$shared$2f$lib$2f$constants__["PHASE_DEVELOPMENT_SERVER"], process.cwd(), undefined, undefined, silent);
    nextConfig.generateBuildId = await nextConfig.generateBuildId?.();
    const customRoutes = await __TURBOPACK__external__next$2f$dist$2f$lib$2f$load$2d$custom$2d$routes__["default"](nextConfig);
    nextConfig.headers = customRoutes.headers;
    nextConfig.rewrites = customRoutes.rewrites;
    nextConfig.redirects = customRoutes.redirects;
    nextConfig.exportPathMap = nextConfig.exportPathMap && {};
    nextConfig.webpack = nextConfig.webpack && {};
    if (nextConfig.experimental?.turbopack?.loaders) {
        ensureLoadersHaveSerializableOptions(nextConfig.experimental.turbopack.loaders);
    }
    return nextConfig;
};
;
function ensureLoadersHaveSerializableOptions(turbopackLoaders) {
    for (const [ext, loaderItems] of Object.entries(turbopackLoaders)){
        for (const loaderItem of loaderItems){
            if (typeof loaderItem !== "string" && !deepEqual(loaderItem, JSON.parse(JSON.stringify(loaderItem)))) {
                throw new Error(`loader ${loaderItem.loader} for match "${ext}" does not have serializable options. Ensure that options passed are plain JavaScript objects and values.`);
            }
        }
    }
}
function deepEqual(a, b) {
    try {
        __TURBOPACK__external__node$3a$assert__["default"].deepStrictEqual(a, b);
        return true;
    } catch  {
        return false;
    }
}

})()),
}]);


//# sourceMappingURL=[next]_entry_config_next.js.map