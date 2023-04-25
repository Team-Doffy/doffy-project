"use client";

import React, { useEffect, useState } from "react";
import Logo from "../../assets/images/logo_AI.svg";
import Warnning from "../../assets/images/warnning.svg";
import ShowInput from "../../assets/images/showinput.svg";
import HideInput from "../../assets/images/hideinput.svg";

const signin: React.FC = () => {
  const [isShowPw, setIsShowPW] = useState<boolean>(false);
  const [isPwMatch, setIsPwMatch] = useState<boolean>(false);

  const handleShowPw = () => {
    setIsShowPW(!isShowPw);
  };

  useEffect(() => {
    setIsShowPW(true);
  }, []);

  const handleMatchPw = () => {
    //백이랑 통신해서 state와 비교하기
  };
  return (
    <>
      {/* <div className="w-full h-full bg-[#F8F8F8]"> */}
      <div className="w-[640px] h-[669px] mx-auto mt-[100px] top-28 flex flex-col border-x-2 border-y-2 border-gray rounded">
        <form>
          <div className="w-[165px] h-[40px] mx-auto mt-20 mb-20">
            <img src={Logo} alt="logo" />
          </div>

          <div className="w-[400px] mx-auto mb-[20px] flex flex-col justify-items-center">
            <label className="mb-[8px]">이메일</label>
            <input
              type="text"
              className="h-[40px] border-x-2 border-y-2 rounded focus:outline-none p-[12px]"
            />
          </div>

          <div className="w-[400px] mx-auto mb-[20px] flex flex-col relative">
            <label className="mb-[8px]">비밀번호</label>
            <input
              type={isShowPw ? "password" : "text"}
              className="h-[40px] mb-[40px] border-x-2 border-y-2 rounded focus:outline-none p-[12px] minLength={8}
              maxLength={12}"
            />
            <div
              className="absolute top-[45px] left-[360px] cursor-pointer"
              onClick={handleShowPw}
            >
              {isShowPw ? <img src={HideInput} /> : <img src={ShowInput} />}
            </div>
          </div>
          {/* <span>* </span> */}

          <div className="w-[400px] mx-auto">
            <div className="w-full h-[52px] m-auto mb-[16px] text-white bg-[#057FEF] leading-[52px] rounded">
              <p className="text-center ">로그인</p>
            </div>
          </div>

          <div className="w-[400px] h-[60px] mx-auto  mb-[40px] flex justify-between border-b-2">
            <div className="flex">
              <input
                type="checkbox"
                className="w-[16px] h-[16px] mt-[4px] mr-[10px]"
              />
              <label id="checbox">로그인 유지</label>
            </div>

            <div className="flex justify-around]">
              <a href="/findid" className="mr-[5px]">
                아이디 찾기
              </a>{" "}
              |{" "}
              <a href="/findpw" className="ml-[5px] mr-[5px]">
                비밀번호 찾기
              </a>{" "}
              |{" "}
              <a href="/signup/step1" className="ml-[5px]">
                회원가입
              </a>
            </div>
          </div>

          <div className="w-[400px] mx-auto flex justify-between">
            <div>
              <span>SNS로 간편하게 시작하기</span>
            </div>
            <div></div>
          </div>
        </form>
      </div>
      {/* </div> */}
    </>
  );
};

export default signin;