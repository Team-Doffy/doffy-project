import Image from "next/image";
import info from "../../../public/icons/Vector.svg";
import TotalRankingButton from "@/pages/community/TotalRankingButton/page";

function UserRankings() {
  return (
    <div className="h-359">
      <div className="bg-white border rounded-t-8 p-20 flex flex-col gap-y-16 relative">
        <div className="flex justify-between items-center">
          <h3 className="font-pretendard not-italic font-bold text-18 leading-21 text-text-color">
            사용자 랭킹
          </h3>
          <div className="flex gap-4">
            <Image src={info} width={10} height={10} alt="info" />
            <h4 className="font-pretendard not-italic font-normal text-13 leading-16 text-grayish">
              점수 산정 방식
            </h4>
          </div>
        </div>
        <div className="border border-border-color" />
        <div className="flex flex-col w-full gap-y-16">
          <div className="flex w-full items-center h-32">
            <div className="font-pretended not-italic font-medium text-16 leading-19">
              <h4>1</h4>
            </div>
            <div className="w-48 h-40 flex justify-center items-center px-8">
              <div className="bg-lightGrey border rounded-16 w-32 h-32" />
            </div>
            <div className="grow font-pretendard not-italic font-medium text-15 leading-18">
              <h4>코린이1</h4>
            </div>
            <div className="font-pretendard not-italic font-normal text-15 leading-18 text-grayish">
              <h4>5600</h4>
            </div>
          </div>

          <div className="flex w-full items-center h-32">
            <div className="font-pretended not-italic font-medium text-16 leading-19">
              <h4>2</h4>
            </div>
            <div className="w-48 h-40 flex justify-center items-center px-8">
              <div className="bg-lightGrey border rounded-16 w-32 h-32" />
            </div>
            <div className="grow font-pretendard not-italic font-medium text-15 leading-18">
              <h4>코린이2</h4>
            </div>
            <div className="font-pretendard not-italic font-normal text-15 leading-18 text-grayish">
              <h4>4600</h4>
            </div>
          </div>

          <div className="flex w-full items-center h-32">
            <div className="font-pretended not-italic font-medium text-16 leading-19">
              <h4>3</h4>
            </div>
            <div className="w-48 h-40 flex justify-center items-center px-8">
              <div className="bg-lightGrey border rounded-16 w-32 h-32" />
            </div>
            <div className="grow font-pretendard not-italic font-medium text-15 leading-18">
              <h4>코린이3</h4>
            </div>
            <div className="font-pretendard not-italic font-normal text-15 leading-18 text-grayish">
              <h4>4400</h4>
            </div>
          </div>

          <div className="flex w-full items-center h-32">
            <div className="font-pretended not-italic font-medium text-16 leading-19">
              <h4>4</h4>
            </div>
            <div className="w-48 h-40 flex justify-center items-center px-8">
              <div className="bg-lightGrey border rounded-16 w-32 h-32" />
            </div>
            <div className="grow font-pretendard not-italic font-medium text-15 leading-18">
              <h4>코린이4</h4>
            </div>
            <div className="font-pretendard not-italic font-normal text-15 leading-18 text-grayish">
              <h4>3800</h4>
            </div>
          </div>

          <div className="flex w-full items-center h-32">
            <div className="font-pretended not-italic font-medium text-16 leading-19">
              <h4>5</h4>
            </div>
            <div className="w-48 h-40 flex justify-center items-center px-8">
              <div className="bg-lightGrey border rounded-16 w-32 h-32" />
            </div>
            <div className="grow font-pretendard not-italic font-medium text-15 leading-18">
              <h4>코린이5</h4>
            </div>
            <div className="font-pretendard not-italic font-normal text-15 leading-18 text-grayish">
              <h4>2900</h4>
            </div>
          </div>
        </div>
      </div>
      <TotalRankingButton />
    </div>
  );
}

export default UserRankings;
