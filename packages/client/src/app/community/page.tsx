import PopularTags from "./PopularTags/page";
import UserRankings from "./UserRankings/page";
import PostSearchBar from "@/pages/community/PostSearchBar/page";
import PostList from "@/pages/community/PostList/page";

function Community() {
  return (
    <div className="h-[calc(100vh-265px)] w-1920 flex justify-center items-center">
      <div className="w-full h-full pt-40 pb-40 pl-180 pr-180">
        <div className="grid grid-cols-community-main grid-rows-community-main w-full h-full gap-x-40">
          <div className="flex flex-col gap-24 h-full">
            <PopularTags />
            <UserRankings />
          </div>

          <div className="flex flex-col w-1284 h-full overflow-y-scroll">
            <PostSearchBar />
            <PostList />
          </div>
        </div>
      </div>
    </div>
  );
}

export default Community;
