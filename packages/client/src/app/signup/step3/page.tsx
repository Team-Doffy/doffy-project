"use client";

import Link from "next/link";
import { useRouter } from "next/navigation";
import React, { ChangeEvent, useEffect, useRef, useState, FC } from "react";
import Step3Logo from "../../../assets/images/step3.svg";
import defaultUserImg from "../../../assets/images/defaultUserImg.svg";

export const Step3: FC = () => {
  const router = useRouter();
  const [nameInput, setNameInput] = useState<string>();
  const [nickNameInput, setNickNameInput] = useState<string>();
  const [pwInput, setPwInput] = useState<string>();
  const [pwCheckInput, setPwCheckInput] = useState<string>();
  const [buttonColor, setButtonColor] = useState<boolean>(false);
  const [userImg, setUserImg] = useState<string>(defaultUserImg);
  const [userImgCancel, setUserImgCancel] = useState<boolean>(false);
  const fileInput = useRef(null);

  // const handleFileChange = (e: ChangeEvent<HTMLInputElement>) => {
  //   const file = e.target.files && e.target.files[0];
  //   if (file) {
  //     setImgFile(file);
  //   }
  // };

  const handleName = (e: ChangeEvent<HTMLInputElement>) => {
    setNameInput(e.target.value);
  };

  const handleNickName = (e: ChangeEvent<HTMLInputElement>) => {
    setNickNameInput(e.target.value);
  };

  const handlePw = (e: ChangeEvent<HTMLInputElement>) => {
    setPwInput(e.target.value);
  };

  const handlePwCheck = (e: ChangeEvent<HTMLInputElement>) => {
    setPwCheckInput(e.target.value);
  };

  const handleFileInput = (e: ChangeEvent<HTMLInputElement>) => {
    if (e.target.files && e.target.files[0]) {
      const file = new FileReader();
      file.onload = () => {
        if (file.readyState === 2) {
          setUserImg(file.result as string);
        }
      };
      file.readAsDataURL(e.target.files[0]);
    } else {
      setUserImg(defaultUserImg);
    }
  };

  const handleFileInputCancel = (e: ChangeEvent<HTMLInputElement>) => {
    setUserImg(defaultUserImg);
  };

  useEffect(() => {
    if (nameInput && nickNameInput) {
      alert("이름이나 닉네임을 확인해주세요.");
    }
    // else if (!pwInput && !pwCheckInput) {
    //   alert("비밀번 혹은 비밀번호 확인 창을 확인해주세요.");
    // }
    else if (pwInput !== pwCheckInput) {
      alert("비밀번호가 일치하지 않습니다.");
    }
    // else {
    //   router.push("/signup/step4");
    // }
  }, [buttonColor]);

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

        <div className="w-[40px] h-[2px] mx-auto mb-[40px] border-b-2"></div>

        {/* 프로필이미지 */}
        <div className="w-[100px] h-[100px] mx-auto mb-[40px] rounded-[50%] bg-[#DDDDDD]">
          <input
            type="file"
            ref={fileInput}
            // style={{ display: "none" }}
            onChange={handleFileInput}
          />
          <img
            src={userImg}
            alt="userprofileimg"
            onClick={() => {}}
            style={{ width: "100px", height: "100px" }}
          />
        </div>

        <div className="w-[400px] mb-[40px] mx-auto flex flex-col relative">
          <label className="mb-[8px]">이름(실명) *</label>
          <input
            type="text"
            placeholder="이름을 입력해주세요"
            onChange={handleName}
            className="w-[400px] h-[40px] p-[12px] rounded border-x-2 border-y-2"
          />
        </div>

        <div className="w-[400px] mb-[40px] mx-auto flex flex-col">
          <span className="mb-[8px]">닉네임 *</span>
          <div className="flex justify-between">
            <input
              placeholder="닉네임을 입력해주세요."
              onChange={handleNickName}
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
            type="password"
            placeholder="영문, 숫자, 특수문자 포함 8~20자를 입력해주세요"
            onChange={handlePw}
            className="w-[400px] h-[40px] p-[12px] rounded border-x-2 border-y-2"
          />
        </div>

        <div className="w-[400px] mx-auto flex flex-col">
          <label className="mb-[8px]">비밀번호 *</label>
          <input
            type="password"
            placeholder="비밀번호를 다시 입력해주세요"
            onChange={handlePwCheck}
            className="w-[400px] h-[40px] p-[12px] rounded border-x-2 border-y-2"
          />
        </div>
      </div>

      {/* 버튼모음 */}
      <div className="w-[640px] h-[64px] mx-auto flex justify-between">
        <Link href="/signup/step2">
          <div className="w-[310px] h-[64px] m-auto mb-[16px] bg-white rounded border-x-2 border-y-2">
            <p className="text-center leading-[64px]">이전</p>
          </div>
        </Link>
        <Link href="/signup/step4">
          <div
            className={`w-[310px] h-[64px] m-auto mb-[16px] text-white ${
              buttonColor ? "bg-[#057FEF]" : "bg-[#DDDDDD]"
            } rounded`}
          >
            <p
              className={`text-center leading-[64px] ${
                buttonColor ? "text-white" : "text-black"
              }`}
            >
              다음
            </p>
          </div>
        </Link>
      </div>
    </div>
  );
};

export default Step3;
