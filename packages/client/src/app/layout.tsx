/* eslint-disable @next/next/no-head-element */

import Footer from "@/components/common/footer";
import Header from "@/components/common/header";
import "../styles/globals.css";
import "tailwindcss/tailwind.css"; // Tailwind CSS import

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html className="h-full">
      <head></head>
      <body className="h-full">
        <Header />
        {children}
        <Footer />
      </body>
    </html>
  );
}
