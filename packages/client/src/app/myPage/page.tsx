"use client";

import { MyDoc } from "./components/myDoc";
import { MyInfo } from "./components/myInfo";

const MyPage: React.FC = (page) => {
  return (
    <div className="w-[90%] mx-auto flex ">
      {/* 마이페이지 네비 */}
      <div className="p-5px mr-[20px] mt-[30px]">
        <div className="w-[240px] flex flex-col rounded-[8px] p-[20px] border-x-2 border-y-2">
          <div className="h-[30px] hover:bg-[#F0F8FF] hover:text-[#057FEF] rounded-[8px] my-[5px]">
            <div className="border-b-2">
              <span className="leading-[30px] p-[10px]  cursor-pointer">
                나의 관심 공식문서
              </span>
            </div>
          </div>

          <div className="border-b-2 ">
            <div className="h-[30px] hover:bg-[#F0F8FF] hover:text-[#057FEF]">
              <span className="leading-[30px] cursor-pointer p-[10px] ">
                나의 정보
              </span>
            </div>
          </div>

          <div className="border-b-2">
            <div className="h-[30px] hover:bg-[#F0F8FF] hover:text-[#057FEF] rounded-[8px] my-[5px]">
              <span className="leading-[30px] cursor-pointer p-[10px]">
                나의 질문
              </span>
            </div>
            <div className="h-[30px] hover:bg-[#F0F8FF] hover:text-[#057FEF] rounded-[8px] my-[5px]">
              <span className="leading-[30px]   cursor-pointer p-[10px]">
                나의 답변
              </span>
            </div>
            <div className="h-[30px] hover:bg-[#F0F8FF] hover:text-[#057FEF] rounded-[8px] my-[5px]">
              <span className="leading-[30px] cursor-pointer p-[10px]">
                저장한 질문
              </span>
            </div>
          </div>

          <div className="h-[30px] hover:bg-[#F0F8FF] hover:text-[#057FEF] rounded-[8px] my-[5px]">
            <span className="leading-[30px] cursor-pointer p-[10px]">
              차단 리스트
            </span>
          </div>
        </div>
      </div>

      {/* 마이페이지 메인 */}
      <div className="w-full">
        {/* <MyDoc /> */}
        <MyInfo />
      </div>
    </div>
  );
};

export default MyPage;
