"use client";

import React, { ChangeEvent, useState, FC } from "react";
import Step4Logo from "../../../assets/images/step4.svg";
import CompleteSignup from "../../../assets/images/completesignup.svg";

export const Step4: FC = () => {
  return (
    <div className="w-full h-full flex flex-col">
      <span className="mx-auto mb-[60px] mt-[120px] text-[48px] font-[700]">
        회원가입
      </span>

      <div className="mx-auto mb-[80px]">
        <img src={Step4Logo} alt="signupstep1img" />
      </div>

      <div className="w-[640px] h-[532px] mx-auto mb-[60px] flex flex-col shadow-[0px 4px 24px gba(175, 175, 175, 0.25)] border-x-2 border-y-2 rounded">
        <div className="w-[120px] h-[129px mx-auto mt-[80px] mb-[31px]">
          <img src={CompleteSignup} alt="signupstep4" />
        </div>

        <span className="w-[400px] mx-auto mb-[60px] text-[28px] text-center">
          님, <br />
          회원이 되신 걸 축하드립니다!
        </span>

        <div className="w-[400px] mx-auto">
          <button className="w-full h-[52px] m-auto mb-[16px] text-white bg-[#057FEF] rounded">
            <p>홈으로</p>
          </button>
        </div>
      </div>
    </div>
  );
};

export default Step4;
