import { QuestionComp } from "./QuestionComp";

export const MyQuestion: React.FC = () => {
  const questionMock = [
    {
      title: "Python 정규표현식을 사용한 패턴 추출",
      questionState: "1",
      skills: ["javascript", "React", "Next"],
      view: 252,
      reply: 179,
      upDown: 254,
      star: 98,
    },
    {
      title:
        "Java 개인 연습 중 배열에서 오류가 났는데 해결 방법을 모르겠습니다.",
      questionState: "1",
      skills: ["javascript", "React", "Next"],
      view: 632,
      reply: 329,
      upDown: 194,
      star: 129,
    },
  ];
  return (
    <div className="flex flex-col">
      <div className="pt-[24px] pb-[24px] border-b-2 mb-[24px]">
        <span className="text-[28px] font-bold">나의 질문</span>
      </div>
      {/* 하단 질문 리스트 */}
      {questionMock.map((quest) => (
        <QuestionComp questComp={quest} />
      ))}
    </div>
  );
};
