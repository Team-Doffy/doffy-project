"use client";
import Image from "next/image";
import bottomArrow from "../../../public/icons/bottomArrow.svg";
import searchIcon from "../../../public/icons/searchIcon.svg";

function PostSearchBar() {
  return (
    <div className="flex h-40 gap-10">
      <div className="border w-160 flex items-center rounded">
        <div className="px-12 py-10 w-full flex justify-between">
          <h3 className="font-pretendard not-italic font-medium text-16 leading-19 text-grayish">
            전체
          </h3>
          <Image src={bottomArrow} alt="bottomArrow" width={10} height={10} />
        </div>
      </div>
      <div className="border w-160 flex items-center rounded">
        <div className="px-12 py-10 w-full flex justify-between">
          <h3 className="font-pretendard not-italic font-medium text-16 leading-19 text-grayish">
            최신순
          </h3>
          <Image src={bottomArrow} alt="bottomArrow" width={10} height={10} />
        </div>
      </div>
      <div className="h-full grow flex">
        <input
          type="text"
          className="border h-full w-352 rounded-l pl-12 placeholder:text-mediumGrey placeholder:font-pretendard placeholder:not-italic placeholder:font-light"
          placeholder="검색어를 입력하세요."
        />
        <button className="border w-48 h-full border-l-0 rounded-r bg-deepblue flex justify-center items-center">
          <Image src={searchIcon} width={16} height={16} alt="searchIcon" />
        </button>
      </div>
      <button className="border w-120 bg-skyblue font-pretendard not-italic font-semibold text-white text-16 leading-24 flex items-center justify-center rounded">
        <div>질문 작성</div>
      </button>
    </div>
  );
}

export default PostSearchBar;
