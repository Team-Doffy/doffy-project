const customJestConfig = {
  preset: "ts-jest",
  setupFilesAfterEnv: ["<rootDir>/jest.setup.ts"], // 각각의 테스트 전에 실행할 모듈을 경로
  moduleDirectories: ["node_modules", "<rootDir>/"],
  testEnvironment: "jest-environment-jsdom",
  moduleNameMapper: {
    "^@/(.*)$": "<rootDir>/src/$1", // tsconfig에서 절대경로 사용 시에 jest가 인식하도록 경로 매핑
    "\\.(jpg|jpeg|png|gif|webp|svg)$": "<rootDir>/src/__mocks__/fileMock.js",
  },
};

module.exports = customJestConfig;
