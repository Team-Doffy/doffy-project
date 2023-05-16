"use client";

import React, { useEffect, useState, FC } from "react";
// import Logo from "../../assets/images/doffylogo.svg";
import Logo from "../../assets/images/doffylogo.svg";
import Warnning from "../../assets/images/warnning.svg";
import ShowInput from "../../assets/images/showinput.svg";
import HideInput from "../../assets/images/hideinput.svg";
import Kakao from "../../assets/images/kakaologin.svg";
import Naver from "../../assets/images/naverlogin.svg";
import Google from "../../assets/images/googlelogin.svg";
import axios from "axios";
import Link from "next/link";

const Signin: FC = () => {
  const [isShowPw, setIsShowPW] = useState<boolean>(false);
  const [isPwMatch, setIsPwMatch] = useState<boolean>(false);
  const [testState, setTestState] = useState("");

  const handleShowPw = () => {
    setIsShowPW(!isShowPw);
  };

  useEffect(() => {
    setIsShowPW(true);
  }, []);

  // const handleTest = () => {
  //   try {
  //     axios.get(
  //       "http://ec2-13-209-70-86.ap-northeast-2.compute.amazonaws.com:8080/test",
  //       {
  //         headers: {
  //           "Content-Type": "application/json",
  //         },
  //       }
  //     );
  //     setTestState("성공");
  //   } catch (error) {
  //     console.log("axios error: " + error);
  //   }
  // };

  return (
    <>
      {/* <div className="w-full h-full bg-[#F8F8F8]"> */}
      <div className="w-[640px] h-[669px] mx-auto mt-[100px] top-28 flex flex-col border-x-2 border-y-2 border-gray rounded shadow-md">
        <form>
          <div className="w-[165px] h-[40px] mx-auto mt-20 mb-20">
            <img src={Logo.src} alt="logo" />
          </div>

          <div className="w-[400px] mx-auto mb-[20px] flex flex-col justify-items-center">
            <label className="mb-[8px]">이메일</label>
            <input
              type="text"
              className="h-[40px] border-x-2 border-y-2 rounded focus:outline-none p-[12px]"
            />
          </div>

          <div className="w-[400px] mx-auto mb-[40px] flex flex-col relative">
            <label className="mb-[8px]">비밀번호</label>
            <div className="flex  border-x-2 border-y-2 rounded">
              <input
                type={isShowPw ? "password" : "text"}
                className="w-[350px] h-[40px] focus:outline-none p-[12px] minLength={8}
              maxLength={12}"
              />
              <div
                className="absolute top-[45px] left-[360px] cursor-pointer"
                onClick={handleShowPw}
              >
                {isShowPw ? (
                  <img src={HideInput.src} />
                ) : (
                  <img src={ShowInput.src} />
                )}
              </div>
            </div>
          </div>

          <div className="w-[400px] mx-auto">
            <div className="w-full h-[52px] m-auto mb-[16px] text-white bg-[#057FEF] leading-[52px] rounded cursor-pointer">
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
              <span className="leading-[50px]">SNS로 간편하게 시작하기</span>
            </div>
            <div className="w-[200px] flex justify-around">
              <Link href="">
                <div className="rounded-[50%] hover:ring">
                  <img src={Kakao.src} alt="kakao" />
                </div>
              </Link>
              <Link href="">
                <div className="rounded-[50%] hover:ring">
                  <img src={Google.src} alt="google" />
                </div>
              </Link>
              <Link href="">
                <div className="rounded-[50%] hover:ring">
                  <img src={Naver.src} alt="naver" />
                </div>
              </Link>
            </div>
          </div>
        </form>
      </div>
      {/* </div> */}
    </>
  );
};

export default Signin;
