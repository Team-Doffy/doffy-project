import React from "react";
import FindPwLogo from "../../assets/images/findpwImg.svg";

const FindPw: React.FC = () => {
  return (
    <div className="w-[640px] h-[636px] mt-[100px] mx-auto flex flex-col border-x-2 border-y-2 border-gray rounded">
      <div className="w-[80px] h-[80px] mt-[80px] mx-auto mb-[40px] rounded-[50%] bg-[#9BC9FF]">
        <img src={FindPwLogo} alt="findpwimg" className="mt-[22px] ml-[22px]" />
      </div>

      <span className="text-[28px] mx-auto mb-[16px]">비밀번호 재설정</span>

      <span className="mx-auto text-[15px] text-[#666666] text-center mb-[40px]">
        비밀번호 재설정 후 로그인이 가능합니다.
      </span>

      <div className="w-[400px] flex flex-col mx-auto">
        <span className="mb-[8px] text-[16px]">새로운 비밀번호</span>
        <input
          type="text"
          placeholder="6자 이상으로 입력해주세요."
          className="h-[40px] mb-[20px] border-x-2 border-y-2 rounded focus:outline-none p-[12px]"
        />
      </div>

      <div className="w-[400px] flex flex-col mx-auto">
        <span className="mb-[8px] text-[16px]">비밀번호 확인</span>
        <input
          type="text"
          placeholder="동일한 비밀번호를 입력해 주세요."
          className="h-[40px] mb-[40px] border-x-2 border-y-2 rounded focus:outline-none p-[12px]"
        />
      </div>

      <div className="w-[400px] mx-auto">
        <button className="w-full h-[52px] m-auto text-white bg-[#057FEF] rounded">
          이메일 전송
        </button>
      </div>
    </div>
  );
};

export default FindPw;
