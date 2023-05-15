import React, { FC } from "react";
import FindIdLogo from "../../assets/images/findidimg.svg";

const FindIdNotice: FC = () => {
  return (
    <div className="w-[640px] h-[558px] mt-[100px] mx-auto flex flex-col border-x-2 border-y-2 border-gray rounded">
      <div className="w-[80px] h-[80px] mt-[80px] mx-auto mb-[40px] rounded-[50%] bg-[#9BC9FF]">
        <img
          src={FindIdLogo.src}
          alt="findidimg"
          className="mt-[22px] ml-[25px]"
        />
      </div>

      <span className="text-[28px] mx-auto mb-[40px]">아이디 찾기 결과</span>

      <span className="mx-auto text-[15px] text-[#666666] text-center mb-[60px]">
        가입된 이메일 입니다.
      </span>

      <div className="w-[400px] mx-auto">
        <button className="w-full h-[52px] m-auto mb-[20px]  text-[18px] font-[700] bg-white rounded border-x-2 border-y-2">
          비밀번호 찾기
        </button>
      </div>

      <div className="w-[400px] mx-auto">
        <button className="w-full h-[52px] m-auto mb-[16px] text-white text-[18px] font-[700] bg-[#057FEF] rounded">
          이메일 검증
        </button>
      </div>
    </div>
  );
};

export default FindIdNotice;
