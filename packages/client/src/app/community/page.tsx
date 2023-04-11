function Community() {
  return (
    <div className="h-[calc(100vh_-_16.563rem)] w-full flex justify-center items-center">
      <div className="w-full h-full pt-10 pb-40 pl-180 pr-180" >
        <div className="grid grid-cols-community-main grid-rows-community-main w-full h-full gap-x-10">
          <div>
            <div className="h-220 bg-white border rounded-lg p-5">
              <div className="border-b-2 border-black">
                인기 태그
              </div>
              <div>
                JavaScript
              </div>
            </div>
            <div>22</div>
          </div>
          <div>33</div>
        </div>    
      </div>
    </div>
  )
}

export default Community;
