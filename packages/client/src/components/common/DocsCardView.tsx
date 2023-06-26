import Image from "next/image";

interface DocsProps {
  width: string;
  docs: {
    id: number;
    title: string;
  };
}

const DocsCardView: React.FC<DocsProps> = ({ width, docs }) => {
  return (
    <div
      className={`${width} h-200 mx-20 my-20 rounded-4 overflow-hidden border-solid border border-gray-300`}
    >
      <div className="mt-6 flex flex-col items-center">
        <div className="pr-6 w-full flex justify-end">
          <Image src="/icons/star1.svg" alt="star" width={25} height={24} />
        </div>

        <div className="p-2 border rounded-100">
          <Image
            src="/icons/react-icon.svg"
            alt="docs_logo"
            width={28}
            height={28}
          />
        </div>
        <p className="pt-5 text-gray-600 text-base">{docs.title}</p>
      </div>
    </div>
  );
};

export default DocsCardView;
