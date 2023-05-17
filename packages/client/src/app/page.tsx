import Head from "next/head";
import Image from "next/image";
import React from "react";

function Main() {
  return (
    <div className="m-10">
      {/* 캐러셀 */}
      <div>
        <Image
          src="/images/banner.svg"
          alt="search_icon"
          width={1560}
          height={480}
        />
      </div>

      <div className="flex space-x-96 items-center">
        {/* 카테고리 네비게이션 바 */}
        <section className="relative m-4">
          <ul className="h-12 flex space-x-8 font-bold text-2xl">
            <li className="after:content-[''] after:absolute after:w-11 after:h-0.5 after:bg-black after:-left-0.5 after:bottom-1">
              전체
            </li>
            <li>언어</li>
            <li>DB</li>
            <li>프레임워크</li>
          </ul>
        </section>
        {/* 검색바 */}
        <div className="m-10 w-96 relative flex">
          {/* #003192 */}
          <input
            className="w-full h-10 p-3 border-solid border-y border-l border-gray-300 rounded-l"
            placeholder="검색어를 입력하세요."
            type="text"
          />

          <button
            className="w-12 h-10 p-3 bg-dark-blue rounded-r flex justify-center"
            type="submit"
          >
            <Image
              src="/icons/search-icon.svg"
              alt="search_icon"
              width={16}
              height={16}
            />
          </button>
        </div>
      </div>

      <div className="m-5">
        검색결과 <span className="font-bold">8</span>건
      </div>

      <main w-full h-full p-44>
        <section className="flex">
          <div className="w-64 h-48 mx-10 my-10 rounded-lg overflow-hidden border-solid border border-gray-300">
            <div className="mt-6 flex flex-col items-center">
              <div className="pr-6 w-full flex justify-end">
                <Image
                  src="/icons/star1.svg"
                  alt="star"
                  width={25}
                  height={24}
                />
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

          {/* 공식문서 카드뷰 */}
          <div className="w-64 h-48 mx-5 my-10 rounded-lg overflow-hidden border-solid border border-gray-300">
            <div className="mt-6 flex flex-col items-center">
              <div className="pr-6 w-full flex justify-end">
                <Image
                  src="/icons/star1.svg"
                  alt="star"
                  width={25}
                  height={24}
                />
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

          {/* 공식문서 카드뷰 */}
          <div className="w-64 h-48 mx-10 my-10 rounded-lg overflow-hidden border-solid border border-gray-300">
            <div className="mt-6 flex flex-col items-center">
              <div className="pr-6 w-full flex justify-end">
                <Image
                  src="/icons/star1.svg"
                  alt="star"
                  width={25}
                  height={24}
                />
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

          {/* 공식문서 카드뷰 */}
          <div className="w-64 h-48 mx-10 my-10 rounded-lg overflow-hidden border-solid border border-gray-300">
            <div className="mt-6 flex flex-col items-center">
              <div className="pr-6 w-full flex justify-end">
                <Image
                  src="/icons/star1.svg"
                  alt="star"
                  width={25}
                  height={24}
                />
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
        </section>
      </main>
    </div>
  );
}

export default Main;
