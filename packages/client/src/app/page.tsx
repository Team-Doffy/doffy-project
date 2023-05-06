import Head from "next/head";
import Image from "next/image";
import React from "react";

function Main() {
  return (
    <>
      <div className="w-64 h-48 mx-10 my-10 rounded-lg overflow-hidden border-solid border border-gray-300">
        <div className="mt-6 flex flex-col items-center">
          <div className="pr-6 w-full flex justify-end">
            <Image src="/icons/star1.svg" alt="star" width={25} height={24} />
          </div>

          <div className="p-2 border rounded-full">
            <Image
              src="/icons/React-icon.svg"
              alt="docs_logo"
              width={28}
              height={28}
            />
          </div>
          <p className="pt-5 text-gray-600 text-base">React.js</p>
        </div>
      </div>
    </>
  );
}

export default Main;
