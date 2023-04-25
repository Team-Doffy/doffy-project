import Head from "next/head";
import Image from "next/image";
import React from "react";

function Main() {
  return (
    <>
      <div className="w-64 h-48 mx-10 my-10 rounded overflow-hidden border-solid border border-gray-300">
        <div className="h-full flex flex-col items-center justify-center">
          <div className="flex items-start">
            <div>
              <div className="p-3 border rounded-full mr-12">
                <Image
                  src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/512px-React-icon.svg.png"
                  alt="docs_logo"
                  width={28}
                  height={28}
                />
              </div>
              <p className="text-gray-600 text-base">React.js</p>
            </div>
            <Image src="/icons/star1.svg" alt="star" width={25} height={24} />
          </div>
        </div>
      </div>
    </>
  );
}

export default Main;
