/* eslint-disable @next/next/no-head-element */

import Footer from "@/components/common/footer";
import Header from "@/components/common/header";

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html>
      <head></head>
      <body>
        <Header />
        {children}
        <Footer />
      </body>
    </html>
  );
}
