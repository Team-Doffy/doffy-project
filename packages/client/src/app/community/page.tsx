function Community() {
  return (
    <div className="h-[calc(100vh_-_16.563rem)] w-full flex justify-center items-center">
      <div className="w-full h-full pt-10 pb-40 pl-180 pr-180">
        <div className="grid grid-cols-community-main grid-rows-community-main w-full h-full gap-x-10">
          <div>
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
            <div>22</div>
          </div>
          <div>33</div>
        </div>
      </div>
    </div>
  );
}

export default Community;
