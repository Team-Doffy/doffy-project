import React from "react";
import Step3Logo from "../../../assets/images/step3.svg";

export const Step1: React.FC = () => {
  return (
    <div className="w-full h-full flex flex-col">
      <span className="mx-auto mb-[60px] mt-[120px] text-[48px] font-[700]">
        회원가입
      </span>

      <div className="mx-auto mb-[80px]">
        <img src={Step3Logo} alt="signupstep1img" />
      </div>

      <div className="w-[640px] h-[784px] mx-auto mb-[60px] flex flex-col shadow-[0px 4px 24px gba(175, 175, 175, 0.25)] border-x-2 border-y-2 rounded">
        <p className="mx-auto mt-[80px] mb-[20px] text-[28px]">회원가입</p>

        <div className="w-[40px] h-[2px] mx-auto mb-[40px] border-x-2">df</div>

        {/* 프로필이미지 */}
        <div className="w-[100px] h-[100px] mx-auto mb-[40px] rounded-[50%] bg-[#DDDDDD]" />

        <div className="w-[400px] mb-[40px] mx-auto flex flex-col">
          <label className="mb-[8px]">이름(실명) *</label>
          <input
            type="text"
            placeholder="이름을 입력해주세요"
            className="w-[400px] h-[40px] p-[12px] rounded border-x-2 border-y-2"
          />
        </div>

        <div className="w-[400px] mb-[40px] mx-auto flex flex-col">
          <span className="mb-[8px]">닉네임 *</span>
          <div className="flex justify-between">
            <input
              type="text"
              placeholder="닉네임을 입력해주세요."
              className="w-[400px] h-[40px] p-[12px] mr-[12px] rounded border-x-2 border-y-2"
            />
            <button className="w-[100px] h-[40px] bg-black text-white rounded">
              <p>중복확인</p>
            </button>
          </div>
        </div>

        <div className="w-[400px] mb-[40px] mx-auto flex flex-col">
          <label className="mb-[8px]">비밀번호 *</label>
          <input
            type="text"
            placeholder="영문, 숫자, 특수문자 포함 8~20자를 입력해주세요"
            className="w-[400px] h-[40px] p-[12px] rounded border-x-2 border-y-2"
          />
        </div>

        <div className="w-[400px] mx-auto flex flex-col">
          <label className="mb-[8px]">비밀번호 *</label>
          <input
            type="text"
            placeholder="비밀번호를 다시 입력해주세요"
            className="w-[400px] h-[40px] p-[12px] rounded border-x-2 border-y-2"
          />
        </div>
      </div>

      {/* 버튼모음 */}
      <div className="w-[640px] h-[64px] mx-auto flex justify-between">
        <button className="w-[310px] h-[64px] m-auto mb-[16px] bg-white rounded border-x-2 border-y-2">
          <p>이전</p>
        </button>
        <button className="w-[310px] h-[64px] m-auto mb-[16px] text-white bg-[#057FEF] rounded">
          <p>다음</p>
        </button>
      </div>
    </div>
  );
};

export default Step1;
