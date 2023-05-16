import Head from "next/head";
import Image from "next/image";
import React from "react";

function Main() {
  return (
    <>
      {/* 카테고리 네비게이션 바 */}
      <section>
        <ul className="h-12 flex space-x-8 font-bold text-2xl">
          <li className="after:content-[''] after:absolute after:w-10 after:h-0.5 after:bg-black after:-left-0.5 after:-bottom-1">
            전체
          </li>
          <li>언어</li>
          <li>DB</li>
          <li>프레임워크</li>
        </ul>
      </section>

      <div>
        검색결과 <span className="font-bold">8</span>건
      </div>

      {/* 공식문서 카드뷰 */}
      <div className="w-64 h-48 mx-10 my-10 rounded-lg overflow-hidden border-solid border border-gray-300">
        <div className="mt-6 flex flex-col items-center">
          <div className="pr-6 w-full flex justify-end">
            <Image src="/icons/star1.svg" alt="star" width={25} height={24} />
          </div>

          <div className="p-2 border rounded-full">
            <Image
              src="/icons/React-icon.svg"
              alt="docs_logo"
              width={28}
              height={28}
            />
          </div>
          <p className="pt-5 text-gray-600 text-base">React.js</p>
        </div>
      </div>
    </>
  );
}

export default Main;
