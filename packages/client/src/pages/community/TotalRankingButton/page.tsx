"use client";
import Image from "next/image";
import rightArrow from "../../../public/icons/rightArrow.svg";

function TotalRankingButton() {
  return (
    <div className="flex justify-center items-center h-42 border rounded-b-8">
      <div className="flex gap-1 items-center">
        <h3 className="font-pretendard not-italic font-medium text-15 leading-18 text-grayish">
          전체 랭킹
        </h3>
        <Image
          src={rightArrow}
          alt="right"
          className="pb-2"
          width={10}
          height={10}
        />
      </div>
    </div>
  );
}

export default TotalRankingButton;
