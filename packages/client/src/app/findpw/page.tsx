import React, { FC } from "react";
import FindPwLogo from "../../assets/images/findpwImg.svg";

const FindPw: FC = () => {
  return (
    <div className="w-[640px] h-[573px] mt-[100px] mx-auto flex flex-col border-x-2 border-y-2 border-gray rounded">
      <div className="w-[80px] h-[80px] mt-[80px] mx-auto mb-[40px] rounded-[50%] bg-[#9BC9FF]">
        <img
          src={FindPwLogo.src}
          alt="findpwimg"
          className="mt-[22px] ml-[22px]"
        />
      </div>

      <span className="text-[28px] mx-auto mb-[16px]">비밀번호 찾기</span>

      <span className="mx-auto text-[15px] text-[#666666] text-center mb-[40px]">
        기존에 가입하신 이메일로 인증번호를 발송해드렸습니다.
        <br /> 메일함을 확인해주세요.
      </span>

      <div className="w-[400px] flex flex-col mx-auto">
        <span className="mb-[8px]">이메일</span>
        <input
          type="text"
          placeholder="이메일을 입력해주세요."
          className="h-[40px] mb-[40px] border-x-2 border-y-2 rounded focus:outline-none p-[12px]"
        />
      </div>

      <div className="w-[400px] mx-auto">
        <button className="w-full h-[52px] m-auto mb-[16px] text-white bg-[#057FEF] rounded">
          이메일 전송
        </button>
      </div>
    </div>
  );
};

export default FindPw;
