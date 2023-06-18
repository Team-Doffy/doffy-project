import { ChangeEvent, useState } from "react";
import ShowInput from "../../../assets/images/showinput.svg";
import HideInput from "../../../assets/images/hideinput.svg";

export const MyInfo: React.FC = () => {
  const [userImg, setUserImg] = useState<String>("");
  const [userKnickName, setUserKnickName] = useState<String>("");
  const [changeEmail, setChangeEamil] = useState<boolean>(false);
  const [changePw, setChangePw] = useState<boolean>(false);
  const [isShowPw, setIsShowPw] = useState<boolean>(false);
  const [isShowChangePw, setIsShowChangePw] = useState<boolean>(false);
  const [isShowChangePw2, setIsShowChangePw2] = useState<boolean>(false);
  const [addSkill, setAddSkill] = useState<boolean>(false);
  const [searchSkillvalue, setSearchSkillvalue] = useState("");

  const handleChangeEmail = () => {
    setChangeEamil(true);
  };

  const handleCancelChangeEmail = () => {
    setChangeEamil(false);
  };

  const handleChangePW = () => {
    setChangePw(true);
  };

  const handleCancelChangePW = () => {
    setChangePw(false);
  };

  const handleShowChangePw = () => {
    setIsShowChangePw(!isShowPw);
  };

  const handleShowChangePw2 = () => {
    setIsShowChangePw2(!isShowChangePw2);
  };

  const handleAddSkill = () => {
    setAddSkill(true);
  };

  const handleSetSkillValue = (e: ChangeEvent<HTMLInputElement>) => {
    setSearchSkillvalue(e.currentTarget.value);
  };

  const skillPoint: { id: number; name: string; point: number }[] = [
    { id: 1, name: "Javascript", point: 2700 },
    { id: 2, name: "Python", point: 3900 },
    { id: 3, name: "React", point: 5400 },
    { id: 4, name: "CSS", point: 4100 },
  ];

  return (
    <div className="flex flex-col">
      {/* 상단 타이틀 */}
      <div className="p-[24px] border-b-2 mb-[24px]">
        <span className="text-[28px] font-bold">나의 정보</span>
      </div>
      {/* 하단 컨텐츠 */}
      <div className="flex">
        {/* 하단 좌측 */}
        <div className="w-[70%] flex border-x-2 border-y-2 mr-[40px] rounded-[8px]">
          {/* 프로필 이미지 부분 */}
          <div className="flex flex-col p-[60px] mr-[40px] items-center">
            <div className="w-[100px] h-[100px] rounded-full bg-[gray]">
              asda
            </div>
            <span className="text-[13px] text-[400] text-[13px] text-[#999999] text-center mt-[20px]">
              5MB 이내의 이미지 <br /> 파일을 업로드 해주세요.
            </span>
          </div>
          {/* 정보 부분 */}
          <div className="flex">
            <div className="flex flex-col mt-[20px] mr-[40px]">
              <div className="flex flex-col">
                <p className="mb-[8px] text-[#999999] text-[15px]">닉네임 *</p>
                <div className="flex mb-[40px]">
                  <div className="flex">
                    <input
                      className="border-x-2 border-y-2 mr-[20px] rounded-[8px] pl-[5px] outline-none"
                      type="text"
                    />
                    <div className="w-[100px] h-[40px] leading-[40px] cursor-pointer text-center rounded-[8px] bg-[black] text-white">
                      중복확인
                    </div>
                  </div>
                </div>
              </div>

              <div className="flex flex-col">
                <p className="mb-[8px] text-[#999999] text-[15px]">
                  이름(실명) *
                </p>
                <div className="flex mb-[40px]">
                  <input
                    className="w-[100%] h-[40px] border-x-2 border-y-2 mr-[20px] rounded-[8px] pl-[5px] outline-none"
                    type="text"
                  />
                </div>
              </div>

              <div className="flex flex-col">
                <p className="mb-[8px] text-[#999999] text-[15px]">이메일 *</p>
                <div className="flex mb-[40px]">
                  <input
                    className="h-[40px] border-x-2 border-y-2 mr-[20px] rounded-[8px] pl-[5px] outline-none"
                    type="text"
                  />
                  {changeEmail && (
                    <div
                      className="w-[100px] h-[40px] leading-[40px] cursor-pointer text-center rounded-[8px] border-x-2 border-y-2 mr-[20px]"
                      onClick={handleCancelChangeEmail}
                    >
                      변경취소
                    </div>
                  )}
                  <div
                    className="w-[100px] h-[40px] leading-[40px] cursor-pointer text-center rounded-[8px] bg-[black] text-white"
                    onClick={handleChangeEmail}
                  >
                    이메일 변경
                  </div>
                </div>
              </div>
              {changeEmail && (
                <div className="flex flex-col mb-[40px]">
                  <p className="mb-[8px] text-[#999999] mb-[20px]">
                    새 이메일 *
                  </p>
                  <div className="flex border-x-2 border-y-2 rounded">
                    <input
                      type="text"
                      placeholder="새 이메일을 입력해주세요"
                      // onChange={handlePw}
                      className="w-[350px] h-[40px] p-[12px]"
                    />
                    <div></div>
                    <div></div>
                  </div>
                </div>
              )}

              <div className="flex flex-col">
                <p className="mb-[8px] text-[#999999] text-[15px]">
                  비밀번호 *
                </p>
                <div className="flex mb-[40px]">
                  <div className="flex">
                    <input
                      className="border-x-2 border-y-2 mr-[20px] rounded-[8px] pl-[5px] outline-none"
                      type="password"
                    />
                    {changePw && (
                      <div
                        className="w-[100px] h-[40px] leading-[40px] cursor-pointer text-center rounded-[8px] border-x-2 border-y-2 mr-[20px]"
                        onClick={handleCancelChangePW}
                      >
                        변경취소
                      </div>
                    )}
                    <div
                      className="w-[100px] h-[40px] leading-[40px] cursor-pointer text-center rounded-[8px] bg-[black] text-white"
                      onClick={handleChangePW}
                    >
                      비밀번호 변경
                    </div>
                  </div>
                </div>
              </div>

              {changePw && (
                <div className="flex flex-col mb-[40px]">
                  <p className="mb-[8px] text-[#999999] mb-[20px]">
                    새 비밀번호 *
                  </p>
                  <div className="flex  border-x-2 border-y-2 rounded">
                    <input
                      type={isShowChangePw ? "password" : "text"}
                      placeholder="영문, 숫자, 특수문자 포함 8~20자를 입력해주세요"
                      // onChange={handlePw}
                      className="w-[350px] h-[40px] p-[12px]"
                    />
                    <div
                      className="absolute top-[45px] left-[360px] cursor-pointer"
                      onClick={handleShowChangePw}
                    >
                      {isShowChangePw ? (
                        <img src={HideInput.src} />
                      ) : (
                        <img src={ShowInput.src} />
                      )}
                    </div>
                  </div>
                </div>
              )}

              {changePw && (
                <div className="flex flex-col mb-[20px]">
                  <label className="mb-[8px] text-[#999999]">
                    비밀번호 확인*
                  </label>
                  <div className="flex  border-x-2 border-y-2 rounded">
                    <input
                      type={isShowChangePw2 ? "password" : "text"}
                      placeholder="영문, 숫자, 특수문자 포함 8~20자를 입력해주세요"
                      // onChange={handlePw}
                      className="w-[350px] h-[40px] p-[12px]"
                    />
                    <div
                      className="absolute top-[45px] left-[360px] cursor-pointer"
                      onClick={handleShowChangePw2}
                    >
                      {isShowChangePw2 ? (
                        <img src={HideInput.src} />
                      ) : (
                        <img src={ShowInput.src} />
                      )}
                    </div>
                  </div>
                </div>
              )}

              <div className="flex flex-col">
                <p className="mb-[8px] text-[#999999]">
                  주요기술 * (최대 4개 선택)
                </p>
                <div className="flex">
                  <div className="p-[5px] border-x-2 border-y-2 rounded-[8px] mr-[20px]">
                    {skillPoint.map((skill) => (
                      <span className="text-[#057FEF] bg-[#F0F8FF] text-[11px] font-normal mb-[10px] p-[5px] rounded-[8px] mr-[10px]">
                        {skill.name}
                      </span>
                    ))}
                  </div>
                  <div
                    className="w-[100px] h-[40px] leading-[40px] cursor-pointer text-center rounded-[8px] bg-[black] text-white"
                    onClick={handleAddSkill}
                  >
                    기술추가
                  </div>
                </div>
              </div>
              {addSkill && (
                <input
                  className="w-[100%] h-[40px] p-[5px] outline-none border-x-2 border-y-2 rounded-[8px] mt-[20px]"
                  type="text"
                  value={searchSkillvalue}
                  onChange={handleSetSkillValue}
                />
              )}
              {searchSkillvalue && (
                <div className="flex flex-col">
                  {/* 여기에서 api로 검색한 기술을 찾아야함 */}
                  {/* <p>{}</p> */}
                </div>
              )}
            </div>
          </div>
        </div>
        {/* 하단 우측 */}
        <div className="w-[30%] h-[345px] rounded-[8px] flex flex-col border-x-2 border-y-2 ">
          <p className="pt-[40px] pl-[40px] ">LV.</p>

          <div className="flex justify-around mt-[20px]">
            <div className="w-full text-center flex flex-col border-r-2">
              <p className="text-[#999999] text-[15px] font-normal">포인트</p>
              <p className="font-medium">5800</p>
            </div>
            <div className="w-full text-center flex flex-col border-r-2">
              <p className="text-[#999999] text-[15px] font-normal cursor-pointer">
                팔로워
              </p>
              <p className="font-medium">124명</p>
            </div>
            <div className="w-full text-center flex flex-col">
              <p className="text-[#999999] text-[15px] font-normal cursor-pointer">
                팔로잉
              </p>
              <p className="font-medium">321명</p>
            </div>
          </div>

          <div className="w-[100%] flex pl-[40px] mt-[30px]">
            <div className="flex flex-col">
              <div className="flex justify-between">
                <p className="text-[15px] font-normal text-[#999999]">태그</p>
                <p className="text-[15px] font-normal text-[#999999]">포인트</p>
              </div>
              {skillPoint.map((skill) => (
                <div className="flex justify-between">
                  <span className="text-[#057FEF] bg-[#F0F8FF] text-[11px] font-normal mb-[10px] p-[5px] rounded-[8px]">
                    {skill.name}
                  </span>
                  <span>{skill.point}</span>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
