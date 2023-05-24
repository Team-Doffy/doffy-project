export const NoticeModal: React.FC = () => {
  return (
    <div className="w-[360px] h-[500px] flex flex-col border-x-2 border-y-2">
      <div className="flex">
        <div className="flex justify-between">
          <span>알림</span>
          <div className="rounded-[13px] text-white bg-[#057FEF] leading-[52px]">
            <p></p>
          </div>
          <span className="text-[#057FEF]"></span>
        </div>
      </div>
    </div>
  );
};
