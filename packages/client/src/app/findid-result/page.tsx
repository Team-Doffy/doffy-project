import React, { FC } from "react";
import FindIdResultLogo from "../../assets/images/findidresult.svg";

const FindIdResult: FC = () => {
  return (
    <div className="w-[640px] h-[486px] mt-[100px] mx-auto flex flex-col border-x-2 border-y-2 border-gray rounded">
      <div className="w-[80px] h-[80px] mt-[80px] mx-auto mb-[40px] rounded-[50%] bg-[#9BC9FF]">
        <img
          src={FindIdResultLogo}
          alt="findidimg"
          className="mt-[22px] ml-[22px]"
        />
      </div>

      <span className="text-[28px] text-black mx-auto mb-[16px]">
        결과 안내
      </span>

      <span className="mx-auto text-[15px] text-[#666666] text-center mb-[60px]">
        가입된 정보를 찾을 수 없습니다.
        <br />
        가입하지 않으셨다면, <span className="text-black">회원가입</span>을
        하시고 서비스를 이용해 주세요.
      </span>

      <div className="w-[400px] mx-auto">
        <button className="w-full h-[52px] m-auto mb-[16px] text-white text-[18px] font-[700] bg-[#057FEF] rounded">
          회원가입
        </button>
      </div>
    </div>
  );
};

export default FindIdResult;
