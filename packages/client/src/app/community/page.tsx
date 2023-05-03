import Image from "next/image";
import user from "../../public/111.svg";
import info from "../../public/icons/Vector.svg";
import rightArrow from "../../public/icons/rightArrow.svg";

function Community() {
  return (
    <div className="h-[calc(100vh_-_16.563rem)] w-full flex justify-center items-center">
      <div className="w-full h-full pt-10 pb-40 pl-180 pr-180">
        <div className="grid grid-cols-community-main grid-rows-community-main w-full h-full gap-x-10">
          <div className="flex flex-col gap-6 h-full">
            <div className="h-220 bg-white border rounded-lg p-5 flex flex-col gap-y-4">
              <h3 className="font-pretendard not-italic font-bold text-18 leading-21 text-text-color">
                인기 태그
              </h3>
              <div className="border border-border-color" />
              <div className="flex flex-col gap-2">
                <div className="flex justify-between w-full">
                  <h4 className="font-pretendard not-italic font-normal text-16 leading-19">
                    JavaScript
                  </h4>
                  <div className="w-27 h-18">
                    <h5 className="font-pretendard not-italic font-medium text-12 leading-14 px-1.5 py-0.5 border rounded-40 bg-number-grey">
                      56
                    </h5>
                  </div>
                </div>

                <div className="flex justify-between w-full">
                  <h4 className="font-pretendard not-italic font-normal text-16 leading-19 text-number-grey">
                    JQuery
                  </h4>
                  <div className="w-27 h-18">
                    <h5 className="font-pretendard not-italic font-medium text-12 leading-14 px-1.5 py-0.5 border rounded-40 bg-number-real-grey text-number-grey">
                      47
                    </h5>
                  </div>
                </div>

                <div className="flex justify-between w-full">
                  <h4 className="font-pretendard not-italic font-normal text-16 leading-19 text-number-grey">
                    React
                  </h4>
                  <div className="w-27 h-18">
                    <h5 className="font-pretendard not-italic font-medium text-12 leading-14 px-1.5 py-0.5 border rounded-40 bg-number-real-grey text-number-grey">
                      36
                    </h5>
                  </div>
                </div>

                <div className="flex justify-between w-full">
                  <h4 className="font-pretendard not-italic font-normal text-16 leading-19 text-number-grey">
                    Linux
                  </h4>
                  <div className="w-27 h-18">
                    <h5 className="font-pretendard not-italic font-medium text-12 leading-14 px-1.5 py-0.5 border rounded-40 bg-number-real-grey text-number-grey">
                      23
                    </h5>
                  </div>
                </div>

                <div className="flex justify-between w-full">
                  <h4 className="font-pretendard not-italic font-normal text-16 leading-19 text-number-grey">
                    Python
                  </h4>
                  <div className="w-27 h-18">
                    <h5 className="font-pretendard not-italic font-medium text-12 leading-14 px-1.5 py-0.5 border rounded-40 bg-number-real-grey text-number-grey">
                      21
                    </h5>
                  </div>
                </div>
              </div>
            </div>
            <div className="h-359">
              <div className="bg-white border rounded-t-lg p-5 flex flex-col gap-y-4 relative">
                <div className="flex justify-between items-center">
                  <h3 className="font-pretendard not-italic font-bold text-18 leading-21 text-text-color">
                    사용자 랭킹
                  </h3>
                  <div className="flex gap-1">
                    <Image src={info} width={10} height={10} alt="info" />
                    <h4 className="font-pretendard not-italic font-normal text-13 leading-16 text-score-color">
                      점수 산정 방식
                    </h4>
                  </div>
                </div>
                <div className="border border-border-color" />
                <div className="flex flex-col w-full gap-y-4">
                  <div className="flex w-full items-center h-8">
                    <div className="font-pretended not-italic font-medium text-16 leading-19">
                      <h4>1</h4>
                    </div>
                    <div className="w-12 h-10 flex justify-center items-center px-2">
                      <div className="bg-user-default-color border rounded-2xl w-8 h-8" />
                    </div>
                    <div className="grow font-pretendard not-italic font-medium text-15 leading-18">
                      <h4>코린이1</h4>
                    </div>
                    <div className="font-pretendard not-italic font-normal text-15 leading-18 text-score-color">
                      <h4>5600</h4>
                    </div>
                  </div>

                  <div className="flex w-full items-center h-8">
                    <div className="font-pretended not-italic font-medium text-16 leading-19">
                      <h4>2</h4>
                    </div>
                    <div className="w-12 h-10 flex justify-center items-center px-2">
                      <div className="bg-user-default-color border rounded-2xl w-8 h-8" />
                    </div>
                    <div className="grow font-pretendard not-italic font-medium text-15 leading-18">
                      <h4>코린이2</h4>
                    </div>
                    <div className="font-pretendard not-italic font-normal text-15 leading-18 text-score-color">
                      <h4>4600</h4>
                    </div>
                  </div>

                  <div className="flex w-full items-center h-8">
                    <div className="font-pretended not-italic font-medium text-16 leading-19">
                      <h4>3</h4>
                    </div>
                    <div className="w-12 h-10 flex justify-center items-center px-2">
                      <div className="bg-user-default-color border rounded-2xl w-8 h-8" />
                    </div>
                    <div className="grow font-pretendard not-italic font-medium text-15 leading-18">
                      <h4>코린이3</h4>
                    </div>
                    <div className="font-pretendard not-italic font-normal text-15 leading-18 text-score-color">
                      <h4>4400</h4>
                    </div>
                  </div>

                  <div className="flex w-full items-center h-8">
                    <div className="font-pretended not-italic font-medium text-16 leading-19">
                      <h4>4</h4>
                    </div>
                    <div className="w-12 h-10 flex justify-center items-center px-2">
                      <div className="bg-user-default-color border rounded-2xl w-8 h-8" />
                    </div>
                    <div className="grow font-pretendard not-italic font-medium text-15 leading-18">
                      <h4>코린이4</h4>
                    </div>
                    <div className="font-pretendard not-italic font-normal text-15 leading-18 text-score-color">
                      <h4>3800</h4>
                    </div>
                  </div>

                  <div className="flex w-full items-center h-8">
                    <div className="font-pretended not-italic font-medium text-16 leading-19">
                      <h4>5</h4>
                    </div>
                    <div className="w-12 h-10 flex justify-center items-center px-2">
                      <div className="bg-user-default-color border rounded-2xl w-8 h-8" />
                    </div>
                    <div className="grow font-pretendard not-italic font-medium text-15 leading-18">
                      <h4>코린이5</h4>
                    </div>
                    <div className="font-pretendard not-italic font-normal text-15 leading-18 text-score-color">
                      <h4>2900</h4>
                    </div>
                  </div>
                </div>
              </div>
              <div className="flex justify-center items-center h-42 border rounded-b-lg">
                <div className="flex gap-1 items-center">
                  <h3 className="font-pretendard not-italic font-medium text-15 leading-18 text-score-color">
                    전체 랭킹
                  </h3>
                  <Image src={rightArrow} alt="right" className="pb-0.5" />
                </div>
              </div>
            </div>
          </div>

          <div className="flex flex-col">
            <div className="flex h-10 gap-2.5">
              <div className="border w-40">드롭다운11111</div>
              <div className="border w-40">드롭다운2222</div>
              <div className="h-full grow">
                <input type="text" className="border h-full w-352" />
                <button className="border w-12 h-full">11</button>
              </div>
              <button className="border w-120">11</button>
            </div>
            <div className="grid"></div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Community;
