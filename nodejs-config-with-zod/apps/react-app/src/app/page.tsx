"use client";

import { useAppConfig } from "@/config/useAppConfig";

export default function Home() {
  const AppConfig = useAppConfig();

  return (
    <main>
      Config: {JSON.stringify(AppConfig)}
    </main>
  )
}
