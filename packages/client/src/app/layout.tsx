/* eslint-disable @next/next/no-head-element */

import Footer from "@/components/common/footer";
import Header from "@/components/common/header";
import "../styles/globals.css";
import { AppProps } from "next/app";
import { SessionProvider } from "next-auth/react";

export default function RootLayout({
  children,
  pageProps,
}: {
  children: React.ReactNode;
  pageProps: AppProps;
}) {
  return (
    // <SessionProvider session={pageProps.session}>
    <html>
      <head></head>
      <body>
        <Header />
        {children}
        <Footer />
      </body>
    </html>
    // </SessionProvider>
  );
}
