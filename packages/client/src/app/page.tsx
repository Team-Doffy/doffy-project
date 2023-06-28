import React from "react";
import Carousel from "@/components/main/Carousel";
import CategoryBar from "@/components/main/CategoryBar";
import SearchBar from "@/components/main/SearchBar";
import DocsList from "@/components/main/DocsList";

const Main: React.FC = () => {
  const docsList = [
    { id: 1, title: "React.js"},
    { id: 2, title: "jQuery" },
    { id: 3, title: "Spring" },
    { id: 4, title: "Tailwind CSS" },
  ];

  return (
    <div className="mt-40 mb-160 mx-180">
      <Carousel />

      <div className="flex justify-between items-center">
        <CategoryBar />
        <SearchBar />
      </div>

      <main>
        <div className="m-3">
          검색결과 <span className="font-bold">8</span>건
        </div>
        <section className="flex">
          <DocsList docsList={docsList} />
        </section>
      </main>
    </div>
  );
};

export default Main;
