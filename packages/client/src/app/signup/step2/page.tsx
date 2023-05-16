"use client";

import React, { useEffect, useState, FC } from "react";
import Step2Logo from "../../../assets/images/step2.svg";

export const Step2: FC = () => {
  const [emailInput, setEmailInput] = useState<string>();
  const [authNumber, setAuthNumber] = useState<string>();
  const [buttonColor, setButtonColor] = useState<boolean>(false);

  useEffect(() => {
    //emailInput의 value가 있고 인증번호 확인이 되면 버튼색이 변경되도록
  }, [buttonColor]);

  const handleAuth = () => {};

  return (
    <div className="w-full h-full flex flex-col">
      <span className="mx-auto mb-[60px] mt-[120px] text-[48px] font-[700]">
        회원가입
      </span>

      <div className="mx-auto mb-[80px]">
        <img src={Step2Logo.src} alt="signupstep1img" />
      </div>

      <div className="w-[640px] h-[430px] mx-auto mb-[60px] flex flex-col shadow-[0px 4px 24px gba(175, 175, 175, 0.25)] border-x-2 border-y-2 rounded">
        <p className="mx-auto mt-[80px] mb-[20px] text-[28px]">이메일 인증</p>

        <div className="w-[40px] h-[2px] mx-auto mb-[40px] border-b-2"></div>

        <div className="w-[400px] mx-auto mb-[40px] flex flex-col shadow-[0px 4px 24px rgba(175, 175, 175, 0.25)]">
          <span className="text-[16px] font-600 mb-[8px]">이메일</span>

          <div className="flex justify-between">
            <input
              type="text"
              placeholder="이메일을 입력해주세요."
              className="w-[290px] h-[40px] p-[12px] border-x-2 border-y-2"
            />
            <button className="w-[100px] h-[40px] bg-black text-white rounded">
              <p>전송</p>
            </button>
          </div>
        </div>

        <div className="w-[400px] mx-auto flex flex-col">
          <span className="text-[16px] font-600">인증번호</span>
          <div className="flex justify-between">
            <input
              type="text"
              placeholder="인증번호를 입력해주세요."
              className="w-[290px] h-[40px] p-[12px] border-x-2 border-y-2"
            />
            <button
              className={`w-[100px] h-[40px] ${
                buttonColor ? "bg-[#057FEF]" : "bg-[#DDDDDD]"
              } text-white rounded`}
            >
              <p>확인</p>
            </button>
          </div>
        </div>
      </div>

      <div className="w-[640px] h-[64px] mx-auto flex justify-between">
        <button className="w-[310px] h-[64px] m-auto mb-[16px] bg-white rounded border-x-2 border-y-2">
          <p>이전</p>
        </button>
        <button
          className={`w-[310px] h-[64px] m-auto mb-[16px] text-white ${
            buttonColor ? "bg-[#057FEF]" : "bg-[#DDDDDD]"
          } rounded`}
        >
          <p>다음</p>
        </button>
      </div>
    </div>
  );
};

export default Step2;
