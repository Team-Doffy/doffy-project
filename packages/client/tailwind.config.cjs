/** @type {import('tailwindcss').Config} */

const colors = {
  skyblue: "#057FEF",
  deepblue: "#003192",
  aliceblue: "#F0F8FF",
  whitesmoke: "#FAFDFF",
  mintgreen: "#08E8C2",
  burntorange: "#F4440C",
  charcoal: "#222222",
  grayish: "#666666",
  darkGrey: "#999999",
  mideumGrey: "#CCCCCC",
  lightGrey: "#D9D9D9",
  softgray: "#DDDDDD",
  offwhite: "#F4F4F4",
  snow: "#F8F8F8",
  midnight: "#00102F",
  navyblue: "#0A1D44",
  slateblue: "#1F3562",
  royalblue: "#324F8D",
  paleblue: "#A8BBD4",
  coolgray: "#C8CFDA",
  white: "#FFFFFF",
};

const convertRemToPx = () => {
  return { ...Array.from({ length: 2000 }, (_, i) => i + "px") };
};

module.exports = {
  content: ["./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    spacing: convertRemToPx(),
    fontSize: convertRemToPx(),
    lineHeight: convertRemToPx(),
    borderRadius: {
      none: "0px",
      ...convertRemToPx(),
    },
    translate: convertRemToPx(),
    skew: convertRemToPx(),

    extend: {
      colors,
      gridTemplateColumns: {
        "community-main": "236px 82.2%",
      },
      gridTemplateRows: {
        "community-main": "100%",
        "content-area": "minmax(0, 13.563rem)",
      },
      fontFamily: {
        pretendard: "Pretendard",
        sans: ["Pretendard-Regular", "sans-serif"],
      },
      margin: {
        "-10": "-0.625rem",
      },
      spacing: {
        "93%": "93%",
        "83.41%": "83.41%",
        18: "1.125rem",
      },
    },
  },
  plugins: [],
};
