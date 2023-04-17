import React from "react";
import Link from "next/link";
import Image from "next/image";

const Header: React.FC = () => {
  return (
    <header className="w-full h-100px flex justify-between items-center p04 bg-white dark:bg-gray-800 border-b-2">
      {/* 헤더 왼측에는 로고, 공식문서, 커뮤니티 */}
      <div className="flex items-center">
        <Link href="/">
          <img src="logo.png" alt="logo" className="w-8 h08 rounded-full" />
        </Link>
        <Link href="/">
          <span className="">공식문서</span>
        </Link>
        <Link href="/">
          <span className="">커뮤니티</span>
        </Link>
      </div>

      {/* 헤더 오른쪽에는 알림버튼, 다크모드 토글, 로그인, 회원가입 */}
      <div className="flex items-center space-x-4">
        <button className="p-2 text-gray-800 dark:text-gray-200 rounded-full hover:bg-gray-200 dark:hover:bg-gray-700 focus:outline-none focus:bg-gray-200 dark:foucs:bg-gray-700">
          알림버튼임
        </button>
        <button className="p-2 text-gray-800 dark:text-gray-200 rounded-full hover:bg-gray-200 dark:hover:bg-gray-700 focus:outline-none focus:bg-gray-200 dark:foucs:bg-gray-700">
          다크모드토글
        </button>

        <Link href="/">
          <img
            src="profile.png"
            alt="profile"
            className="w-20 h-20 rounded-full hover: scale-50"
          />
        </Link>

        <Link href="/">
          <span className="px-4 py-2 text-white bg-blue-500 rounded-lg hover:bg-blue-600 foucs:outline-none focus:bg-blue-600">
            로그인
          </span>
        </Link>
        <Link href="/">
          <span className="px-4 py-2 text-white bg-blue-500 rounded-lg hover:bg-blue-600 foucs:outline-none focus:bg-blue-600">
            회원가입
          </span>
        </Link>
      </div>
    </header>
  );
};
export default Header;
