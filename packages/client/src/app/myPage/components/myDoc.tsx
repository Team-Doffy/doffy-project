"use client";

import { useState } from "react";
import Warning from "../../../assets/images/warning.svg";

export const MyDoc: React.FC = () => {
  const [isModal, setIsModal] = useState<boolean>(false);

  const handleModal = () => {
    setIsModal(!isModal);
  };

  return (
    // 메인
    <div className="w-full flex flex-col">
      {/* 상단 */}
      <div className="flex justify-between p-[24px] border-b-2 mb-[24px] text-center">
        <span className="text-[28px] font-bold">나의 관심 공식문서</span>
        <div
          className="w-[130px] h-[44px] text-white bg-[#057FEF] text-center leading-[44px] rounded-[8px] cursor-pointer"
          onClick={handleModal}
        >
          폴더추가 +
        </div>
        {isModal && (
          <div className="w-[480px] h-[250px] rounded-[8px] border-x-2 border-y-2 p-[30px] flex flex-col">
            <div className="p-[10px] border-b-2">
              <span className="text-[20px] text-center">
                이 폴더를 삭제 하시겠나요?
              </span>
            </div>
            <div className="p-[30px] text-center">
              <Warning />
              <span className="text-[15px]">
                이 폴더와 저장된 모든 공식문서가 영구적으로 삭제됩니다.
              </span>
            </div>
            <div className="flex">
              <button
                className="w-[195px] h-[45px] rounded-[8px] border-x-2 border-y-2 mr-[20px]"
                onClick={handleModal}
              >
                취소
              </button>
              <button className="w-[195px] h-[45px] rounded-[8px] border-x-2 border-y-2 text-white bg-[#057FEF]">
                확인
              </button>
            </div>
          </div>
        )}
      </div>
      {/* 하단 */}
      <div className="flex">
        {/* 하단 좌측 */}
        <div className="flex flex-col overflow-scroll"></div>
        {/* 하단 우측 */}
        <div className="">
          <div className="w-[268pw] rounded-[8px] sticky border-x-2 border-y-2">
            <div className="flex">
              <span className="text-[13px] ml-[15px]">
                드래그 & 드랍 기능을 사용해 보세요.
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
