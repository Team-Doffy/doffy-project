import Image from "next/image";

const SearchBar = () => {
  return (
    <div>
      <div className="w-400 relative flex">
        <input
          className="w-352 h-40 p-12 border-solid border-y border-l border-gray-300 rounded-l-4"
          placeholder="검색어를 입력하세요."
          type="text"
        />
        <button
          className="w-48 h-40 p-3 bg-deepblue rounded-r-4 flex justify-center items-center"
          type="submit"
        >
          <Image
            src="/icons/search-icon.svg"
            alt="search_icon"
            width={16}
            height={16}
          />
        </button>
      </div>
      {/* <div className="w-352 absolute">
        <div className="w-full h-30 border-solid border-x border-t border-gray-300 rounded-t-4">
          Java
        </div>
        <div className="w-full h-30 border-x border-gray-300">dd</div>
        <div className="w-full h-30 border-solid border-x border-b border-gray-300 rounded-b-4">
          Java<span className="text-gray-300">Script</span>
        </div>
      </div> */}
    </div>
  );
};

export default SearchBar;
