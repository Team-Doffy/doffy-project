function PopularTags() {
  return (
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
  );
}

export default PopularTags;
