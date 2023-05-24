"use client";

import React, { useState } from "react";
import Link from "next/link";
import Logo from "../../assets/images/doffylogo.svg";
import noti from "../../assets/images/notification.svg";
import Image from "next/image";
import { NoticeModal } from "./noticeModal";

const Header: React.FC = () => {
  const [isSignin, setIsSignin] = useState<boolean>(false);
  const [isModal, setIsModal] = useState<boolean>(false);
  const [darkmodeToggle, setDarkModeToggle] = useState<boolean>(false);

  const isModalState = () => {
    setIsModal(!isModal);
  };

  return (
    <header className="w-full h-[70px] sticky items-center bg-white dark:bg-gray-800 drop-shadow-md fixed top-0">
      <div className="w-4/5 flex justify-between left-[10%] mt-[15px] fixed">
        {/* 헤더 왼측에는 로고, 공식문서, 커뮤니티 */}
        <div className="flex items-center">
          <Link href="/">
            <img src={Logo.src} alt="logo" className="mr-[8px]" />
          </Link>
          <Link href="/">
            <span className="text-base font-bold text-lg ml-4 hover:text-blue-500">
              공식문서
            </span>
          </Link>
          <Link href="/community">
            <span className="text-base font-bold text-lg ml-4 hover:text-blue-500">
              커뮤니티
            </span>
          </Link>
        </div>

        {/* 헤더 오른쪽에는 알림버튼, 다크모드 토글, 로그인, 회원가입 */}
        <div className="flex items-center space-x-4">
          <div className="mr-6 relative cursor-pointer" onClick={isModalState}>
            <img src={noti.src} alt="noti" />
            {/* {isModal && <NoticeModal />} */}
          </div>

          {/* <div className=" flex flex-col items-center justify-center min-h-screen overflow-hidden">
            <div className="flex">
              <label className="inline-flex relative items-center mr-5 cursor-pointer">
                <input
                  type="checkbox"
                  className="sr-only peer"
                  checked={darkmodeToggle}
                  readOnly
                />
                <div
                  onClick={() => {
                    setDarkModeToggle(!darkmodeToggle);
                  }}
                  className="w-11 h-6 bg-gray-200 rounded-full peer  peer-focus:ring-green-300  peer-checked:after:translate-x-full peer-checked:after:border-white after:content-[''] after:absolute after:top-0.5 after:left-[2px] after:bg-white after:border-gray-300 after:border after:rounded-full after:h-5 after:w-5 after:transition-all peer-checked:bg-green-600"
                ></div>
              </label>
            </div>
          </div> */}
          <div className=""></div>

          <Link href="/signin">
            <span className="px-4 py-2 hover:text-blue-500 font-bold text-lg">
              로그인
            </span>
          </Link>
          <Link href="/signup/step1">
            <span className="px-4 py-2 hover:text-blue-500 font-bold text-lg">
              회원가입
            </span>
          </Link>
        </div>
      </div>
    </header>
  );
};
export default Header;
