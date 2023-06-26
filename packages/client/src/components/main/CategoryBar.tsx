const CategoryBar = () => {
  return (
    <section className="relative">
      <ul className="h-47 flex space-x-28 font-bold text-24">
        <li className="after:content-[''] after:absolute after:w-42 after:h-2 after:bg-black after:-left-2 after:bottom-4">
          전체
        </li>
        <li>언어</li>
        <li>DB</li>
        <li>프레임워크</li>
      </ul>
    </section>
  );
};

export default CategoryBar;
