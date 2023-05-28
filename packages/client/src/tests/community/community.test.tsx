import React, { FC } from "react";
import { renderHook, waitFor, render, screen } from "@testing-library/react";
import renderer from "react-test-renderer";
import Community from "@/app/community/page";
import { ImageProps } from "next/image";

interface MockImageProps extends Omit<ImageProps, "src"> {
  src: string;
}

jest.mock("next/image", () => {
  const Image: FC<MockImageProps> = (props) => <img {...props} />;
  return Image;
});

describe("community", () => {
  it("렌더 확인", () => {
    console.log("test");

    const community = renderer.create(<Community />);
  });
});
