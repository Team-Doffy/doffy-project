import React from "react";
import Step1Logo from "../../../assets/images/step1.svg";

export const Step1: React.FC = () => {
  return (
    <div className="w-full h-full flex flex-col">
      <span className="mx-auto mb-[60px] mt-[120px] text-[48px] font-[700]">
        회원가입
      </span>

      <div className="mx-auto mb-[60px]">
        <img src={Step1Logo} alt="signupstep1img" />
      </div>

      <div className="w-[1320px] h-[399px] mx-auto mb-[60px] flex flex-col">
        <span>이용약관 *</span>
        <div className="w-[1320px] h-[320px] rounded border-x-2 border-y-2"></div>
        <div>
          <input
            type="checkbox"
            className="w-[16px] h-[16px] mt-[4px] mr-[8px]"
          />
          <label id="checkbox" className="text-[15px] font-400 text-[#666666]">
            동의합니다.
          </label>
        </div>
      </div>

      <div className="w-[1320px] h-[399px] mx-auto mb-[60px] flex flex-col">
        <span>개인정보 수집 및 이용안내 *</span>
        <div className="w-[1320px] h-[320px] rounded border-x-2 border-y-2"></div>
        <div>
          <input
            type="checkbox"
            className="w-[16px] h-[16px] mt-[4px] mr-[8px]"
          />
          <label id="checkbox" className="text-[15px] font-400 text-[#666666]">
            동의합니다.
          </label>
        </div>
      </div>

      <div className="mx-auto mb-[60px]">
        <input
          type="checkbox"
          className="w-[16px] h-[16px] mt-[4px] mr-[8px]"
        />
        <label id="checkbox" className="text-[15px] font-400 text-[#666666]">
          전체 약관에 동의합니다.
        </label>
      </div>

      <div className="w-[310px] h-[64px] mx-auto bg-[#DDDDDD] rounded">
        <button className="m-auto text-[18px]">
          <p>다음</p>
        </button>
      </div>
    </div>
  );
};

export default Step1;
