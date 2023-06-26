import Image from "next/image";

const Carousel = () => {
  return (
    <div>
      <Image
        src="/images/banner.svg"
        alt="search_icon"
        width={1560}
        height={480}
        className="w-full"
      />
      <ul className="flex gap-x-12 bg-deepblue">
        <li className="w-36 h-12 rounded-10 bg-white"></li>
        <li className="w-12 h-12 opacity-30 rounded-100 bg-white"></li>
        <li className="w-12 h-12 opacity-30 rounded-100 bg-white"></li>
        <li className="w-12 h-12 opacity-30 rounded-100 bg-white"></li>
        <button>
          <Image
            src="/icons/left-arrow.svg"
            alt="search_icon"
            width={7}
            height={12}
          />
        </button>
        <button>
          <Image
            src="/icons/pause-icon.svg"
            alt="search_icon"
            width={6}
            height={12}
          />
        </button>
        <button>
          <Image
            src="/icons/right-arrow.svg"
            alt="search_icon"
            width={7}
            height={12}
          />
        </button>
      </ul>
    </div>
  );
};

export default Carousel;
