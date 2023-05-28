import Image from "next/image";
import info from "../../public/icons/Vector.svg";
import rightArrow from "../../public/icons/rightArrow.svg";
import bottomArrow from "../../public/icons/bottomArrow.svg";
import searchIcon from "../../public/icons/searchIcon.svg";
import startIcon from "../../public/icons/start.svg";
import commentIcon from "../../public/icons/comment.svg";
import eyesIcon from "../../public/icons/eyes.svg";
import countIcon from "../../public/icons/count.svg";

function Community() {
  return (
    <div className="h-[calc(100vh-265px)] w-1920 flex justify-center items-center">
    <div className="w-full h-full pt-40 pb-40 pl-180 pr-180">
      <div className="grid grid-cols-community-main grid-rows-community-main w-full h-full gap-x-40">
        <div className="flex flex-col gap-24 h-full">
          <div className="h-220 bg-white border rounded-8 p-20 flex flex-col gap-y-16">
            <h3 className="font-pretendard not-italic font-bold text-18 leading-21 text-text-color">
              인기 태그
            </h3>
            <div className="border border-border-color" />
            <div className="flex flex-col gap-8">
              <div className="flex justify-between w-full">
                <h4 className="font-pretendard not-italic font-normal text-16 leading-19">
                  JavaScript
                </h4>
                <div className="w-27 h-18">
                  <h5 className="font-pretendard not-italic font-medium text-12 leading-14 px-6 py-2 border rounded-40 bg-deepblue text-white">
                    56
                  </h5>
                </div>
              </div>
              <div className="flex justify-between w-full">
                <h4 className="font-pretendard not-italic font-normal text-16 leading-19 text-lightgray">
                  JQuery
                </h4>
                <div className="w-27 h-18">
                  <h5 className="font-pretendard not-italic font-medium text-12 leading-14 px-6 py-2 border rounded-40 bg-snow text-lightgray">
                    47
                  </h5>
                </div>
              </div>
              <div className="flex justify-between w-full">
                <h4 className="font-pretendard not-italic font-normal text-16 leading-19 text-lightgray">
                  React
                </h4>
                <div className="w-27 h-18">
                  <h5 className="font-pretendard not-italic font-medium text-12 leading-14 px-6 py-2 border rounded-40 bg-snow text-lightgray">
                    36
                  </h5>
                </div>
              </div>
              <div className="flex justify-between w-full">
                <h4 className="font-pretendard not-italic font-normal text-16 leading-19 text-lightgray">
                  Linux
                </h4>
                <div className="w-27 h-18">
                  <h5 className="font-pretendard not-italic font-medium text-12 leading-14 px-6 py-2 border rounded-40 bg-snow text-lightgray">
                    23
                  </h5>
                </div>
              </div>
              <div className="flex justify-between w-full">
                <h4 className="font-pretendard not-italic font-normal text-16 leading-19 text-lightgray">
                  Python
                </h4>
                <div className="w-27 h-18">
                  <h5 className="font-pretendard not-italic font-medium text-12 leading-14 px-6 py-2 border rounded-40 bg-snow text-lightgray">
                    21
                  </h5>
                </div>
              </div>
            </div>
          </div>
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
            <div className="flex justify-center items-center h-42 border rounded-b-8">
              <div className="flex gap-1 items-center">
                <h3 className="font-pretendard not-italic font-medium text-15 leading-18 text-grayish">
                  전체 랭킹
                </h3>
                <Image
                  src={rightArrow}
                  alt="right"
                  className="pb-0.5"
                  width={10}
                  height={10}
                />
              </div>
            </div>
          </div>
          </div>

          <div className="flex flex-col w-1284 h-full overflow-y-scroll">
          <div className="flex h-40 gap-10">
            <div className="border w-160 flex items-center rounded">
              <div className="px-12 py-10 w-full flex justify-between">
                <h3 className="font-pretendard not-italic font-medium text-16 leading-19 text-grayish">
                  전체
                </h3>
                <Image src={bottomArrow} alt="bottomArrow" width={10} height={10} />
              </div>
            </div>
            <div className="border w-160 flex items-center rounded">
              <div className="px-12 py-10 w-full flex justify-between">
                <h3 className="font-pretendard not-italic font-medium text-16 leading-19 text-grayish">
                  최신순
                </h3>
                <Image src={bottomArrow} alt="bottomArrow" width={10} height={10} />
              </div>
            </div>
            <div className="h-full grow flex">
              <input
                type="text"
                className="border h-full w-352 rounded-l pl-12 placeholder:text-mediumGrey placeholder:font-pretendard placeholder:not-italic placeholder:font-light"
                placeholder="검색어를 입력하세요."
              />
              <button className="border w-48 h-full border-l-0 rounded-r bg-deepblue flex justify-center items-center">
                <Image src={searchIcon} width={16} height={16} alt="searchIcon" />
              </button>
            </div>
            <button className="border w-120 bg-skyblue font-pretendard not-italic font-semibold text-white text-16 leading-24 flex items-center justify-center rounded">
              <div>질문 작성</div>
            </button>
          </div>
          <div className="grid pt-39 gap-24">
            <div className="w-full h-217 relative p-24 border-softgray border rounded-8">
              <div className="absolute bg-deepblue left-93% bottom-83.41% w-90 h-36 flex justify-center items-center rounded-tr-8 rounded-bl-8">
                <h4 className="text-white font-pretendard not-italic font-semibold text-11 leading-13">
                  답변 대기중
                </h4>
              </div>
              <div className="flex flex-col gap-16">
                <div className="font-pretendard not-italic font-bold text-18 leading-21 text-charcoal">Python 정규표현식을 사용한 패턴 추출</div>
                <div className="font-pretendard not-italic font-normal text-16 leading-19 text-grayish">파이썬의 정규표현식을 사용하여 특정 패턴을 추출하고자 합니다. (정규표현식 외에 더 좋은 방법이 있으면 상관없습니다) <br/> 예를들어 -> 안녕하세요 오늘은 (12.05.26) 입니다 789261-12.</div>
                <div className="flex gap-8">
                  <div className="bg-aliceblue px-8 py-4">
                    <h5 className="text-skyblue font-pretendard not-italic font-normal text-11 leading-13">Python</h5>
                  </div>
                  <div className="bg-aliceblue px-8 py-4">
                    <h5 className="text-skyblue font-pretendard not-italic font-normal text-11 leading-13">JavaScript</h5>
                  </div>
                  <div className="bg-aliceblue px-8 py-4">
                    <h5 className="text-skyblue font-pretendard not-italic font-normal text-11 leading-13">React</h5>
                  </div>
                  <div className="bg-aliceblue px-8 py-4">
                    <h5 className="text-skyblue font-pretendard not-italic font-normal text-11 leading-13">String</h5>
                  </div>
                </div>
                <div className="border border-dashed"></div>
                <div className="flex justify-between">
                  <div className="flex gap-20">
                    <div className="flex gap-8 items-center">
                      <h3 className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">작성자: </h3>
                      <div className="bg-lightGrey border rounded-16 w-24 h-24" />
                      <div className="font-pretendard not-italic font-medium text-15 leading-18 text-charcoal">코린이</div>
                      <div className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">12시간 전</div>
                    </div>
                    <div className="text-softgray">|</div>
                    <div className="flex items-center relative gap-8">
                      <h4 className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">참여자:</h4>
                      <div className="flex items-center relative">
                        <div className="bg-lightGrey border rounded-16 w-24 h-24 absolute" />
                        <div className="bg-lightGrey border rounded-16 w-24 h-24 absolute left-18" />
                        <div className="bg-lightGrey border rounded-16 w-24 h-24 absolute left-36 flex justify-center items-center">
                          <h5 className="font-pretendard not-italic font-normal text-12 leading-14">+1</h5>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div className="flex gap-20"> 
                    <div className="flex gap-4 items-center">
                      <Image
                        src={eyesIcon}
                        width={24}
                        height={24}
                        alt="eyesIcon"
                      />
                      <h5 className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">565</h5>
                    </div>
                    <div className="flex gap-4 items-center">
                      <Image
                        src={commentIcon}
                        width={24}
                        height={24}
                        alt="commentIcon"
                      />
                      <h5 className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">28</h5>
                    </div>
                    <div className="flex gap-4 items-center">
                      <Image
                        src={countIcon}
                        width={24}
                        height={24}
                        alt="countIcon"
                      />
                      <h5 className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">16</h5>
                    </div>
                    <div className="flex gap-4 items-center">
                      <Image
                        src={startIcon}
                        width={24}
                        height={24}
                        alt="startIcon"
                      />
                      <h5 className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">12</h5>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="w-full h-217 relative p-24 border-softgray border rounded-8">
              <div className="absolute bg-deepblue left-93% bottom-83.41% w-90 h-36 flex justify-center items-center rounded-tr-8 rounded-bl-8">
                <h4 className="text-white font-pretendard not-italic font-semibold text-11 leading-13">
                  답변 대기중
                </h4>
              </div>
              <div>222</div>
            </div>
            <div className="w-full h-217 relative p-24 border-softgray border rounded-8">
              <div className="absolute bg-deepblue left-93% bottom-83.41% w-90 h-36 flex justify-center items-center rounded-tr-8 rounded-bl-8">
                <h4 className="text-white font-pretendard not-italic font-semibold text-11 leading-13">
                  답변 대기중
                </h4>
              </div>
              <div>333</div>
            </div>
            <div className="w-full h-217 relative p-24 border-softgray border rounded-8">
              <div className="absolute bg-deepblue left-93% bottom-83.41% w-90 h-36 flex justify-center items-center rounded-tr-8 rounded-bl-8">
                <h4 className="text-white font-pretendard not-italic font-semibold text-11 leading-13">
                  답변 대기중
                </h4>
              </div>
              <div>444</div>
            </div>
          </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Community;
