import { useEffect, useState } from "react";
import ViewEye from "../../../assets/images/eyeView.svg";
import Reply from "../../../assets/images/replyIcon.svg";
import Up from "../../../assets/images/upLike.svg";
import Down from "../../../assets/images/downHate.svg";
import Star from "../../../assets/images/star.svg";

interface QuestionProps {
  questComp: Question;
}

type Question = {
  title?: string;
  questionState?: string;
  content?: string;
  skills?: string[];
  view?: number;
  reply?: number;
  upDown?: number;
  star?: number;
};

export const QuestionComp: React.FC<QuestionProps> = (props) => {
  const [questionStatus, setQuestionStatus] = useState();
  const [viewCount, setViewCount] = useState<number>(0);
  const [replyCount, setReplyCount] = useState<number>(0);
  const [likeHateCounte, setLikeHateCount] = useState<number>(0);
  const [starCount, setStarCount] = useState<number>(0);

  useEffect(() => {
    //여기에서 저장한 공식문서 리스트 api 불러오기
  }, []);

  return (
    <div className="w-full flex flex-col rounded-[8px] border-x-2 border-y-2 mb-[20px] cursor-pointer">
      <div className="flex justify-between">
        <span className="p-[24px] text-[18px] font-black">
          {props.questComp.title}
        </span>
        <div className="w-[90px] h-[36px] rounded-tr-[8px] bg-[#057FEF] text-white leading-[36px] text-center rounded-bl-[8px] border-l-2 border-b-2">
          {props.questComp.questionState}
        </div>
      </div>
      <div className="pl-[24px] mb-[20px] text-[16] font-normal text-[#666666]">
        파이썬의 정규표현식을 사용하여 특정 패턴을 추출하고자 합니다.
        (정규표현식 외에 더 좋은 방법이 있으면 상관없습니다)
        <br />
        예를들어 - 안녕하세요 오늘은 (12.0.5.26)입니다. 789261-12/.
      </div>
      <div className="flex justify-between mb-[20px]">
        <div className="flex ml-[20px]">
          {props.questComp.skills?.map((skill) => (
            <span className="text-[#057FEF] bg-[#F0F8FF] text-[11px] font-normal mb-[10px] mr-[20px] p-[5px] rounded-[8px]">
              {skill}
            </span>
          ))}
          <div className="flex">
            <div className="flex mr-[20px] cursor-pointer">
              <div className="mr-[20px]">{/* <ViewEye /> */}</div>
              <p>32</p>
            </div>
            <div className="flex mr-[20px]">
              <div className="mr-[20px]">{/* <Reply /> */}</div>
              <p>19</p>
            </div>
            <div className="flex mr-[20px]">
              <div className="mr-[20px]">{/* <Up/> */}</div>
              <p>12</p>
              <div>{/* <Down /> */}</div>
            </div>
            <div className="flex mr-[20px]">
              <div className="mr-[20px]">{/* <Star /> */}</div>
              <p>9</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
