"use client";

import Link from "next/link";
import { useRouter } from "next/navigation";
import React, { ChangeEvent, useEffect, useState, FC } from "react";
import Step1Logo from "../../../assets/images/step1.svg";

export const Step1: FC = () => {
  const router = useRouter();
  const [checkList, setCheckList] = useState<string[]>([]);
  const [buttonColor, setButtonColor] = useState<boolean>(false);

  const handleCheckAll = (e: ChangeEvent<HTMLInputElement>) => {
    e.target.checked ? setCheckList(["terms", "collect"]) : setCheckList([]);
  };

  const handleCheck = (e: ChangeEvent<HTMLInputElement>) => {
    e.target.checked
      ? setCheckList([...checkList, e.target.name])
      : setCheckList(checkList.filter((choice) => choice !== e.target.name));
  };

  const handleNextPage = () => {
    if (buttonColor) {
      router.push("signup/step2");
    } else if (!buttonColor) {
      alert("동의사항에 체크해주세요.");
    }
  };

  useEffect(() => {
    if (checkList.length === 2) {
      setButtonColor(true);
    } else {
      setButtonColor(false);
    }
  }, [checkList]);

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
            name="terms"
            onChange={handleCheck}
            checked={checkList.includes("terms") ? true : false}
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
            name="collect"
            onChange={handleCheck}
            checked={checkList.includes("collect") ? true : false}
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
          name="all"
          onChange={handleCheckAll}
          checked={checkList.length === 2 ? true : false}
          className="w-[16px] h-[16px] mt-[4px] mr-[8px]"
        />
        <label id="checkbox" className="text-[15px] font-400 text-[#666666]">
          전체 약관에 동의합니다.
        </label>
      </div>

      <div className="w-[310px] h-[64px] mx-auto">
        <div
          className={`w-full h-full m-auto text-[18px] rounded ${
            buttonColor ? "bg-[#057FEF]" : "bg-[#DDDDDD]"
          }`}
          onClick={handleNextPage}
        >
          <Link href="signup/step2">
            <p
              className={`text-center leading-[64px] ${
                buttonColor ? "text-white" : "text-black"
              }`}
            >
              다음
            </p>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Step1;
