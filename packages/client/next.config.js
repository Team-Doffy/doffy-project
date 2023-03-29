/** @type {import('next').NextConfig} */
module.exports = {

    experimental: {
        appDir: true,
    },
}


// /**
//  * 터보팩에서 아래 옵션 추가 시 동작하지 않아
//  * 배포일때만 옵션을 추가하도록 수정
//  */
// if (process.env.MODE === "production") {
//     nextConfig.compiler = {
//         styledComponents: true, // styled-components ssr 활성화
//         removeConsole: true, // 배포 시 콘솔 제거
//     };
//     nextConfig.swcMinify = true;
// }