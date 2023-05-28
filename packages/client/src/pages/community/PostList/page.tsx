"use client";
import Image from "next/image";
import startIcon from "../../../public/icons/start.svg";
import commentIcon from "../../../public/icons/comment.svg";
import eyesIcon from "../../../public/icons/eyes.svg";
import countIcon from "../../../public/icons/count.svg";

function PostList() {
  return (
    <div className="grid pt-39 gap-24">
      <div className="w-full h-217 relative p-24 border-softgray border rounded-8">
        <div className="absolute bg-deepblue left-93% bottom-83.41% w-90 h-36 flex justify-center items-center rounded-tr-8 rounded-bl-8">
          <h4 className="text-white font-pretendard not-italic font-semibold text-11 leading-13">
            답변 대기중
          </h4>
        </div>
        <div className="flex flex-col gap-16">
          <div className="font-pretendard not-italic font-bold text-18 leading-21 text-charcoal">
            Python 정규표현식을 사용한 패턴 추출
          </div>
          <div className="font-pretendard not-italic font-normal text-16 leading-19 text-grayish">
            파이썬의 정규표현식을 사용하여 특정 패턴을 추출하고자 합니다.
            (정규표현식 외에 더 좋은 방법이 있으면 상관없습니다) <br /> 예를들어
            -&gt 안녕하세요 오늘은 (12.05.26) 입니다 789261-12.
          </div>
          <div className="flex gap-8">
            <div className="bg-aliceblue px-8 py-4">
              <h5 className="text-skyblue font-pretendard not-italic font-normal text-11 leading-13">
                Python
              </h5>
            </div>
            <div className="bg-aliceblue px-8 py-4">
              <h5 className="text-skyblue font-pretendard not-italic font-normal text-11 leading-13">
                JavaScript
              </h5>
            </div>
            <div className="bg-aliceblue px-8 py-4">
              <h5 className="text-skyblue font-pretendard not-italic font-normal text-11 leading-13">
                React
              </h5>
            </div>
            <div className="bg-aliceblue px-8 py-4">
              <h5 className="text-skyblue font-pretendard not-italic font-normal text-11 leading-13">
                String
              </h5>
            </div>
          </div>
          <div className="border border-dashed"></div>
          <div className="flex justify-between">
            <div className="flex gap-20">
              <div className="flex gap-8 items-center">
                <h3 className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">
                  작성자:{" "}
                </h3>
                <div className="bg-lightGrey border rounded-16 w-24 h-24" />
                <div className="font-pretendard not-italic font-medium text-15 leading-18 text-charcoal">
                  코린이
                </div>
                <div className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">
                  12시간 전
                </div>
              </div>
              <div className="text-softgray">|</div>
              <div className="flex items-center relative gap-8">
                <h4 className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">
                  참여자:
                </h4>
                <div className="flex items-center relative">
                  <div className="bg-lightGrey border rounded-16 w-24 h-24 absolute" />
                  <div className="bg-lightGrey border rounded-16 w-24 h-24 absolute left-18" />
                  <div className="bg-lightGrey border rounded-16 w-24 h-24 absolute left-36 flex justify-center items-center">
                    <h5 className="font-pretendard not-italic font-normal text-12 leading-14">
                      +1
                    </h5>
                  </div>
                </div>
              </div>
            </div>
            <div className="flex gap-20">
              <div className="flex gap-4 items-center">
                <Image src={eyesIcon} width={24} height={24} alt="eyesIcon" />
                <h5 className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">
                  565
                </h5>
              </div>
              <div className="flex gap-4 items-center">
                <Image
                  src={commentIcon}
                  width={24}
                  height={24}
                  alt="commentIcon"
                />
                <h5 className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">
                  28
                </h5>
              </div>
              <div className="flex gap-4 items-center">
                <Image src={countIcon} width={24} height={24} alt="countIcon" />
                <h5 className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">
                  16
                </h5>
              </div>
              <div className="flex gap-4 items-center">
                <Image src={startIcon} width={24} height={24} alt="startIcon" />
                <h5 className="font-pretendard not-italic font-normal text-13 leading-16 text-darkGrey">
                  12
                </h5>
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
  );
}

export default PostList;
